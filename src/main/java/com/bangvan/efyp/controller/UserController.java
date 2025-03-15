package com.bangvan.efyp.controller;


import com.bangvan.efyp.dto.request.user.UpdateProfileRequest;
import com.bangvan.efyp.dto.request.user.UserCreationRequest;
import com.bangvan.efyp.dto.response.ApiResponse;
import com.bangvan.efyp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
@Slf4j
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create User", description = "Create User")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserCreationRequest request){
        log.info("Request: {}", request);
        ApiResponse apiResponse = ApiResponse.success(201, "User created successfully", userService.createUser(request));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update User", description = "Update User")
    @PutMapping("/update/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long userId, @Valid @RequestBody UpdateProfileRequest request){
        ApiResponse apiResponse = ApiResponse.success(200, "User updated successfully", userService.updateUser(userId, request));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
        ApiResponse apiResponse = ApiResponse.success(200, "User deleted successfully", userService.deleteUser(userId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation(summary = "Find User By Id", description = "Find User By Id")
    @GetMapping("/find/{userId}")
    public ResponseEntity<ApiResponse> findUserById(@PathVariable Long userId){
        ApiResponse apiResponse = ApiResponse.success(200, "User found successfully", userService.findUserById(userId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation(summary = "Find All Users", description = "Find All Users")
    @GetMapping("/find-all")
    public ResponseEntity<ApiResponse> findAllUsers(
            @RequestParam(value= "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(value="sortDir", defaultValue = "ASC", required = false) String sortDir
            ){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        ApiResponse apiResponse = ApiResponse.success(200, "Users found successfully", userService.findAllUsers(pageable));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



}
