package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.dto.request.auth.LoginRequest;
import com.bangvan.efyp.dto.request.user.RegisterRequest;
import com.bangvan.efyp.dto.response.TokenResponse;
import com.bangvan.efyp.dto.response.user.AdvisorResponse;
import com.bangvan.efyp.dto.response.user.StudentResponse;
import com.bangvan.efyp.dto.response.user.UserResponse;
import com.bangvan.efyp.entity.*;
import com.bangvan.efyp.exception.AppException;
import com.bangvan.efyp.exception.ErrorCode;
import com.bangvan.efyp.repository.FacultyRepository;
import com.bangvan.efyp.repository.MajorRepository;
import com.bangvan.efyp.repository.RoleRepository;
import com.bangvan.efyp.repository.UserRepository;
import com.bangvan.efyp.service.AuthenticationService;
import com.bangvan.efyp.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final MajorRepository majorRepository;
    private final FacultyRepository facultyRepository;

    private void authenticateUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception exception) {
            throw new AppException(ErrorCode.USER_UNAUTHENTICATED);
        }
    }


    private UserResponse mapUserResponseByUserType(User user) {
        if (user instanceof Student) {
            return modelMapper.map(user, StudentResponse.class);
        }

        if (user instanceof Advisor) {
            return modelMapper.map(user, AdvisorResponse.class);
        }

        return modelMapper.map(user, UserResponse.class);
    }


    @Override
    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.ACCESS_DENIED));

        if (!user.isEnabled()) {
            throw new AppException(ErrorCode.USER_NOT_VERIFIED);
        }

        // Xác thực username và password
        authenticateUser(loginRequest);


        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);


        long now = System.currentTimeMillis();

        return TokenResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(mapUserResponseByUserType(user))
                .expiredTime(new Timestamp(now + jwtService.getExpirationTime()))
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserResponse register(RegisterRequest request){
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
                student.setRoles(Set.of(roleRepository.findByName("ROLE_STUDENT").orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                if (request.getMajorName() != null) {
                    Major major = majorRepository.getByName(request.getMajorName())
                            .orElseGet(() -> {
                                Major newMajor = new Major();
                                newMajor.setName(request.getMajorName());
                                return majorRepository.save(newMajor);
                            });
                    student.setMajor(major);
                }
                if (request.getGraduationTime() != null) {
                    student.setGraduationTime(request.getGraduationTime());
                }
                user = student;

                break;
            case "ADVISOR":
                Advisor advisor = modelMapper.map(request, Advisor.class);
                advisor.setPassword(passwordEncoder.encode(request.getPassword()));
                advisor.setRoles(Set.of(roleRepository.findByName("ROLE_ADVISOR").orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND))));
                if (request.getFacultyName() != null) {
                    Faculty faculty = facultyRepository.getByName(request.getFacultyName())
                            .orElseGet(() -> {
                                Faculty newFaculty = new Faculty();
                                newFaculty.setName(request.getFacultyName());
                                return facultyRepository.save(newFaculty);
                            });
                    advisor.setFaculty(faculty);
                }
                if (request.getAcademicDegree() != null) {
                    advisor.setAcademicDegree(request.getAcademicDegree());
                }
                user = advisor;
                break;
            default:
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
        }

        log.info("Saving user to database");
        user= userRepository.save(user);
        return mapUserResponseByUserType(user);
    }

    @Override
    public TokenResponse refreshToken(String refreshToken) {
        if (jwtService.isTokenExpired(refreshToken)) {
            throw new AppException(ErrorCode.TOKEN_EXPIRED);
        }
        String username = jwtService.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        String newAccessToken = jwtService.generateToken(user);
        String newRefreshToken = jwtService.generateRefreshToken(user);


        long now = System.currentTimeMillis();
        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .user(mapUserResponseByUserType(user))
                .expiredTime(new Timestamp(now + jwtService.getExpirationTime()))
                .build();
    }


}
