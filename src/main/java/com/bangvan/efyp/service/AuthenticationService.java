package com.bangvan.efyp.service;

import com.bangvan.efyp.dto.request.auth.LoginRequest;
import com.bangvan.efyp.dto.response.TokenResponse;

public interface AuthenticationService {

    TokenResponse login(LoginRequest loginRequest);
}
