package com.bangvan.efyp.service;

import com.bangvan.efyp.dto.request.auth.LoginRequest;
import com.bangvan.efyp.dto.request.user.RegisterRequest;
import com.bangvan.efyp.dto.response.TokenResponse;
import com.bangvan.efyp.dto.response.user.UserResponse;

public interface AuthenticationService {

    TokenResponse login(LoginRequest loginRequest);

    UserResponse register(RegisterRequest request);

    TokenResponse refreshToken(String refreshToken);
}
