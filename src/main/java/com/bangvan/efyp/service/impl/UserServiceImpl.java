package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.dto.request.user.ChangePasswordRequest;
import com.bangvan.efyp.dto.request.user.UpdateProfileRequest;
import com.bangvan.efyp.dto.request.user.UserCreationRequest;
import com.bangvan.efyp.dto.response.PageCustomResponse;
import com.bangvan.efyp.dto.response.user.UserResponse;
import com.bangvan.efyp.entity.Role;
import com.bangvan.efyp.entity.User;
import com.bangvan.efyp.exception.AppException;
import com.bangvan.efyp.exception.ErrorCode;
import com.bangvan.efyp.exception.ResourceNotFoundException;
import com.bangvan.efyp.repository.RoleRepository;
import com.bangvan.efyp.repository.UserRepository;
import com.bangvan.efyp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserResponse createUser(UserCreationRequest request){
        log.info("Creating user based on user request");
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        if (userRepository.existsByPhone(request.getPhone())){
            throw new AppException(ErrorCode.PHONE_EXISTED);
        }

        if (userRepository.existsByUsername(request.getEmail())){
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        User user = modelMapper.map(request, User.class);

        Role role = roleRepository.findByName("ROLE_STUDENT").orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        user.setRoles(Set.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        log.info("Saving user to database");
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(Long userId, UpdateProfileRequest request){
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
        modelMapper.map(request,user);
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public String deleteUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));

        userRepository.delete(user);
        return "user with "+ userId +" was deleted successfully";
    }

    @Override
    public UserResponse loadUserByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("user","userId",username));
        return modelMapper.map(user,UserResponse.class);
    }

    @Override
    public UserResponse findUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
        return modelMapper.map(user,UserResponse.class);

    }

    @Override
    public PageCustomResponse<UserResponse> findAllUsers(Pageable pageable){
        Page<User> page = userRepository.findAll(pageable);
        PageCustomResponse<UserResponse> pageCustom = PageCustomResponse.<UserResponse>builder()
                .pageNo(page.getNumber()+1)
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageContent(page.getContent().stream().map(user->{
                    return modelMapper.map(user,UserResponse.class);
                }).toList())
                .build();
        return pageCustom;
    }

    @Override
    public UserResponse changePassword(Principal principal, ChangePasswordRequest request){
        User user = userRepository.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("user", "userId", principal.getName()));
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }


}
