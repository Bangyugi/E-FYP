package com.bangvan.efyp.controller;

import com.bangvan.efyp.dto.request.auth.LoginRequest;
import com.bangvan.efyp.dto.response.ApiResponse;
import com.bangvan.efyp.dto.response.TokenResponse;
import com.bangvan.efyp.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Authentication", description = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "Login", description = "Login API")
    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse>login (@RequestBody LoginRequest loginRequest){
        ApiResponse authentication =  ApiResponse.success(200, "User logged in successfully", authenticationService.login(loginRequest));

        return new ResponseEntity<>(authentication, HttpStatus.OK);
    }

}
