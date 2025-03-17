package com.bangvan.efyp.service;

import com.bangvan.efyp.dto.request.user.ChangePasswordRequest;
import com.bangvan.efyp.dto.request.user.UpdateProfileRequest;
import com.bangvan.efyp.dto.request.user.UserCreationRequest;
import com.bangvan.efyp.dto.response.PageCustomResponse;
import com.bangvan.efyp.dto.response.user.UserResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

public interface UserService {
    @Transactional
    UserResponse createUser(UserCreationRequest request);

    UserResponse updateUser(Long userId, UpdateProfileRequest request);

    String deleteUser(Long userId);

    UserResponse loadUserByUsername(String username);

    UserResponse findUserById(Long userId);

    PageCustomResponse<UserResponse> findAllUsers(Pageable pageable);

    UserResponse changePassword(Principal principal, ChangePasswordRequest request);
}
