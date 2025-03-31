package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.dto.request.user.ChangePasswordRequest;
import com.bangvan.efyp.dto.request.user.UpdateProfileRequest;
import com.bangvan.efyp.dto.request.user.UserCreationRequest;
import com.bangvan.efyp.dto.response.PageCustomResponse;
import com.bangvan.efyp.dto.response.user.AdvisorResponse;
import com.bangvan.efyp.dto.response.user.StudentResponse;
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




    private UserResponse mapUserResponseByUserType(User user) {
        if (user instanceof Student) {
            return modelMapper.map(user, StudentResponse.class);
        }

        if (user instanceof Advisor) {
            return modelMapper.map(user, AdvisorResponse.class);
        }

        return modelMapper.map(user, UserResponse.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserResponse createUser(UserCreationRequest request){
        log.info("Creating user based on user request");
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        if (userRepository.existsByPhone(request.getPhone())){
            throw new AppException(ErrorCode.PHONE_EXISTED);
        }

        if (userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        User user;

        switch (request.getUserType().toUpperCase()) {
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
                if (request.getGraduationTime() != null) {
                    student.setGraduationTime(request.getGraduationTime());
                }
                user = student;
                break;
            case "ADVISOR":
                Advisor advisor = modelMapper.map(request, Advisor.class);
                advisor.setPassword(passwordEncoder.encode(request.getPassword()));
                advisor.setRoles(Set.of(roleRepository.findByName("ROLE_ADVISOR")
                        .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                if (request.getFacultyName() != null) {
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
            case "USER":
                User admin = modelMapper.map(request, User.class);
                admin.setPassword(passwordEncoder.encode(request.getPassword()));
                admin.setRoles(Set.of(roleRepository.findByName(request.getRoleName())
                        .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                user = admin;
                break;

            default:
                throw new AppException(ErrorCode.INVALID_USER_TYPE);

        }

        log.info("Saving user to database");
        user= userRepository.save(user);
        return mapUserResponseByUserType(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserResponse updateUser(Long userId, UpdateProfileRequest request){
        log.info("Updating user with ID: {}", userId);
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
        // Check email, phone trùng (trừ khi là chính user hiện tại)
        if (userRepository.existsByEmailAndUserIdNot(request.getEmail(), userId)) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (userRepository.existsByPhoneAndUserIdNot(request.getPhone(), userId)) {
            throw new AppException(ErrorCode.PHONE_EXISTED);
        }
        switch (request.getUserType().toUpperCase()) {
            case "STUDENT":
                if (!(user instanceof Student student)){
                    throw new AppException(ErrorCode.INVALID_USER_TYPE);
                }
                modelMapper.map(request,user);
                if (request.getMajorName() != null){
                    Major major = majorRepository.getByName(request.getMajorName())
                            .orElseGet(()->{
                                Major newMajor = new Major();
                                newMajor.setName(request.getMajorName());
                                return majorRepository.save(newMajor);
                            });
                    student.setMajor(major);
                }
                if (request.getGraduationTime() != null) {
                    student.setGraduationTime(request.getGraduationTime());
                }
                break;
            case "ADVISOR":
                if (!(user instanceof Advisor advisor)){
                    throw new AppException(ErrorCode.INVALID_USER_TYPE);
                }
                modelMapper.map(request,user);
                if (request.getFacultyName() != null){
                    Faculty faculty = facultyRepository.getByName(request.getFacultyName())
                            .orElseGet(()->{
                                Faculty newFaculty = new Faculty();
                                newFaculty.setName(request.getFacultyName());
                                return facultyRepository.save(newFaculty);
                            });
                    advisor.setFaculty(faculty);
                }
                break;
            case "USER":
                if (user == null){
                    throw new AppException(ErrorCode.INVALID_USER_TYPE);
                }
                modelMapper.map(request,user);
                break;
            default:
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
        }
        user = userRepository.save(user);
        return mapUserResponseByUserType(user);

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
        return mapUserResponseByUserType(user);
    }

    @Override
    public PageCustomResponse<UserResponse> findAllUsers(Pageable pageable){
        Page<User> page = userRepository.findAll(pageable);
        return PageCustomResponse.<UserResponse>builder()
                .pageNo(page.getNumber()+1)
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageContent(page.getContent().stream().map(this::mapUserResponseByUserType
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
        return mapUserResponseByUserType(user);
    }


}
