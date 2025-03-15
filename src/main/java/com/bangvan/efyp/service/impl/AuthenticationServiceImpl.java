package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.dto.request.auth.LoginRequest;
import com.bangvan.efyp.dto.response.TokenResponse;
import com.bangvan.efyp.dto.response.user.UserResponse;
import com.bangvan.efyp.entity.User;
import com.bangvan.efyp.exception.AppException;
import com.bangvan.efyp.exception.ErrorCode;
import com.bangvan.efyp.exception.ResourceNotFoundException;
import com.bangvan.efyp.repository.UserRepository;
import com.bangvan.efyp.service.AuthenticationService;
import com.bangvan.efyp.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    private void authenticateUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception exception) {
            throw new AppException(ErrorCode.USER_UNAUTHENTICATED);
        }
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
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);

        long now = System.currentTimeMillis();

        return TokenResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(userResponse)
                .expiredTime(new Timestamp(now + jwtService.getExpirationTime()))
                .build();
    }

}
