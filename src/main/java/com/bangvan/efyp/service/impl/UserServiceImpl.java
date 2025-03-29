package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.dto.request.user.ChangePasswordRequest;
import com.bangvan.efyp.dto.request.user.UpdateProfileRequest;
import com.bangvan.efyp.dto.request.user.UserCreationRequest;
import com.bangvan.efyp.dto.response.PageCustomResponse;
import com.bangvan.efyp.dto.response.user.UserResponse;
import com.bangvan.efyp.entity.*;
import com.bangvan.efyp.exception.AppException;
import com.bangvan.efyp.exception.ErrorCode;
import com.bangvan.efyp.exception.ResourceNotFoundException;
import com.bangvan.efyp.repository.FacultyRepository;
import com.bangvan.efyp.repository.MajorRepository;
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
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final MajorRepository majorRepository;
    private final FacultyRepository facultyRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserResponse createUser(UserCreationRequest request){
        log.info("Creating user based on user request");
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        if (userRepository.existsByPhone(request.getPhone())){
            throw new AppException(ErrorCode.PHONE_EXISTED);
        }

        if (userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        User user;

        switch (request.getUserType().toUpperCase()){
            case "STUDENT":
                Student student = modelMapper.map(request, Student.class);
                student.setPassword(passwordEncoder.encode(request.getPassword()));
                student.setRoles(Set.of(roleRepository.findByName("ROLE_STUDENT")
                        .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                if (request.getMajorName() != null) {
                    Optional<Major> major = majorRepository.getByName(request.getMajorName());
                    if (major.isPresent()) {
                        student.setMajor(major.get());
                    } else {
                        Major newMajor = new Major();
                        newMajor.setName(request.getMajorName());
                        newMajor = majorRepository.save(newMajor);
                        student.setMajor(newMajor);
                    }
                }
                user = student;
                break;
            case "ADVISOR":
                Advisor advisor = modelMapper.map(request, Advisor.class);
                advisor.setPassword(passwordEncoder.encode(request.getPassword()));
                advisor.setRoles(Set.of(roleRepository.findByName("ROLE_ADVISOR")
                        .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                if (request.getFacultyName() !=null){
                    Optional<Faculty> faculty = facultyRepository.getByName(request.getFacultyName());
                    if (faculty.isPresent()) {
                        advisor.setFaculty(faculty.get());
                    } else {
                        Faculty newFaculty = new Faculty();
                        newFaculty.setName(request.getFacultyName());
                        newFaculty = facultyRepository.save(newFaculty);
                        advisor.setFaculty(newFaculty);
                    }
                }
                user = advisor;
                break;
            case "ADMIN":
                User admin = modelMapper.map(request, User.class);
                admin.setPassword(passwordEncoder.encode(request.getPassword()));
                admin.setRoles(Set.of(roleRepository.findByName("ROLE_ADMIN")
                        .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                user = admin;
                break;
            case "SUPERADMIN":
                User superAdmin = modelMapper.map(request, User.class);
                superAdmin.setPassword(passwordEncoder.encode(request.getPassword()));
                superAdmin.setRoles(Set.of(roleRepository.findByName("ROLE_SUPERADMIN")
                        .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                user = superAdmin;
                break;

            default:
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
        }

        log.info("Saving user to database");
        user= userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(Long userId, UpdateProfileRequest request){
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
        modelMapper.map(request,user);
        user=userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public String deleteUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));

        userRepository.delete(user);
        return "user with "+ userId +" was deleted successfully";
    }


    @Override
    public UserResponse findUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
        return modelMapper.map(user,UserResponse.class);

    }

    @Override
    public PageCustomResponse<UserResponse> findAllUsers(Pageable pageable){
        Page<User> page = userRepository.findAll(pageable);
        return PageCustomResponse.<UserResponse>builder()
                .pageNo(page.getNumber()+1)
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageContent(page.getContent().stream().map(user->
                    modelMapper.map(user,UserResponse.class)
                ).toList())
                .build();
    }

    @Override
    public UserResponse changePassword(Principal principal, ChangePasswordRequest request){
        User user = userRepository.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("user", "userId", principal.getName()));
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        user=userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }


}
