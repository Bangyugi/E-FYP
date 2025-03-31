package com.bangvan.efyp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
import com.bangvan.efyp.service.impl.UserServiceImpl;
import com.bangvan.efyp.utils.Gender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.util.Collections;
import java.util.Optional;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    // ----------------- Test cho createUser -----------------

    @Test
    @DisplayName("createUser: Tạo người dùng thành công")
    void testCreateUserSuccess() {
        // Chuẩn bị dữ liệu
        UserCreationRequest request = new UserCreationRequest();
        request.setEmail("test@gmail.com");
        request.setPhone("123456789");
        request.setPassword("password");
        request.setUsername("9999999999");
        request.setGender(Gender.MALE);
        request.setFirstName("Trần");
        request.setLastName("Văn Bằng");


        User mappedUser = new User();
        mappedUser.setEmail("test@gmail.com");
        mappedUser.setPhone("123456789");
        mappedUser.setPassword("password");
        mappedUser.setUsername("9999999999");
        mappedUser.setGender(Gender.MALE);
        mappedUser.setFirstName("Trần");
        mappedUser.setLastName("Văn Bằng");

        Role role = new Role();
        role.setName("ROLE_STUDENT");

        User savedUser = new User();
        savedUser.setEmail("test@gmail.com");
        savedUser.setPhone("123456789");
        savedUser.setPassword("encodedPassword");
        savedUser.setUsername("9999999999");
        savedUser.setGender(Gender.MALE);
        savedUser.setFirstName("Trần");
        savedUser.setLastName("Văn Bằng");
        savedUser.setRoles(Collections.singleton(role));

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("test@gmail.com");
        userResponse.setPhone("123456789");
        userResponse.setUsername("9999999999");
        userResponse.setGender(Gender.MALE);
        userResponse.setFirstName("Trần");
        userResponse.setLastName("Văn Bằng");
        userResponse.setRoles(Collections.singleton(role));



        // Setup mock: kiểm tra điều kiện tồn tại của email, phone, username
        when(userRepository.existsByEmail(request.getEmail())).thenReturn(false);
        when(userRepository.existsByPhone(request.getPhone())).thenReturn(false);
        when(userRepository.existsByUsername(request.getEmail())).thenReturn(false);
        when(modelMapper.map(request, User.class)).thenReturn(mappedUser);
        when(roleRepository.findByName("ROLE_STUDENT")).thenReturn(Optional.of(role));
        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(modelMapper.map(savedUser, UserResponse.class)).thenReturn(userResponse);


        // Gọi phương thức cần test
        UserResponse result = userService.createUser(request);

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals("test@gmail.com", result.getEmail());
        assertEquals("123456789", result.getPhone());
        verify(userRepository).save(any(User.class));
    }

    @Test
    @DisplayName("createUser: Ném exception khi email đã tồn tại")
    void testCreateUserExistingEmail() {
        UserCreationRequest request = new UserCreationRequest();
        request.setEmail("test@gmail.com");
        request.setPhone("123456789");

        when(userRepository.existsByEmail(request.getEmail())).thenReturn(true);

        AppException ex = assertThrows(AppException.class, () -> userService.createUser(request));
        assertEquals(ErrorCode.USERNAME_EXISTED, ex.getErrorCode());
    }

    // ----------------- Test cho updateUser -----------------

    @Test
    @DisplayName("updateUser: Cập nhật người dùng thành công")
    void testUpdateUserSuccess() {
        Long userId = 1L;
        UpdateProfileRequest request = new UpdateProfileRequest();
        request.setEmail("new@gmail.com");
        request.setPhone("0987654321");

        User existingUser = new User();
        existingUser.setUserId(userId);
        existingUser.setEmail("old@gmail.com");
        existingUser.setPhone("0123456789");

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("new@gmail.com");
        userResponse.setPhone("0987654321");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        // Giả sử modelMapper.map thực hiện cập nhật trực tiếp đối tượng đã có
        doNothing().when(modelMapper).map(request, existingUser);
        when(userRepository.save(existingUser)).thenReturn(existingUser);
        when(modelMapper.map(existingUser, UserResponse.class)).thenReturn(userResponse);

        UserResponse result = userService.updateUser(userId, request);

        assertNotNull(result);
        assertEquals("new@gmail.com", result.getEmail());
        assertEquals("0987654321", result.getPhone());
    }

    @Test
    @DisplayName("updateUser: Ném exception khi người dùng không tồn tại")
    void testUpdateUserNotFound() {
        Long userId = 1L;
        UpdateProfileRequest request = new UpdateProfileRequest();

        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(userId, request));
    }

    // ----------------- Test cho deleteUser -----------------

    @Test
    @DisplayName("deleteUser: Xoá người dùng thành công")
    void testDeleteUserSuccess() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setUserId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        doNothing().when(userRepository).delete(existingUser);

        String result = userService.deleteUser(userId);
        assertTrue(result.contains("deleted successfully"));
        verify(userRepository).delete(existingUser);
    }

    @Test
    @DisplayName("deleteUser: Ném exception khi người dùng không tồn tại")
    void testDeleteUserNotFound() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userService.deleteUser(userId));
    }

    // ----------------- Test cho findUserById -----------------

    @Test
    @DisplayName("findUserById: Tìm người dùng theo id thành công")
    void testFindUserByIdSuccess() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setUserId(userId);
        existingUser.setEmail("test@gmail.com");

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("test@gmail.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(modelMapper.map(existingUser, UserResponse.class)).thenReturn(userResponse);

        UserResponse result = userService.findUserById(userId);
        assertNotNull(result);
        assertEquals("test@gmail.com", result.getEmail());
    }

    @Test
    @DisplayName("findUserById: Ném exception khi người dùng không tồn tại")
    void testFindUserByIdNotFound() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userService.findUserById(userId));
    }

    // ----------------- Test cho findAllUsers -----------------

    @Test
    @DisplayName("findAllUsers: Lấy danh sách người dùng theo phân trang thành công")
    void testFindAllUsersSuccess() {
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.ASC, "createdAt");
        User user = new User();
        user.setEmail("test@gmail.com");
        List<User> users = Collections.singletonList(user);
        Page<User> userPage = new PageImpl<>(users, pageable, users.size());

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("test@gmail.com");

        when(userRepository.findAll(pageable)).thenReturn(userPage);
        when(modelMapper.map(user, UserResponse.class)).thenReturn(userResponse);

        PageCustomResponse<UserResponse> result = userService.findAllUsers(pageable);
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(1, result.getPageNo());
    }

    // ----------------- Test cho changePassword -----------------

    @Test
    @DisplayName("changePassword: Thay đổi mật khẩu thành công")
    void testChangePasswordSuccess() {
        String username = "testuser";
        Principal principal = () -> username;

        ChangePasswordRequest request = new ChangePasswordRequest();
        request.setOldPassword("oldPass");
        request.setNewPassword("newPass");

        User existingUser = new User();
        existingUser.setUsername(username);
        existingUser.setPassword("encodedOldPass");

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("test@gmail.com");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(existingUser));
        when(passwordEncoder.matches("oldPass", "encodedOldPass")).thenReturn(true);
        when(passwordEncoder.encode("newPass")).thenReturn("encodedNewPass");
        when(userRepository.save(existingUser)).thenReturn(existingUser);
        when(modelMapper.map(existingUser, UserResponse.class)).thenReturn(userResponse);

        UserResponse result = userService.changePassword(principal, request);
        assertNotNull(result);
        verify(userRepository).save(existingUser);
    }

    @Test
    @DisplayName("changePassword: Ném exception khi mật khẩu cũ không hợp lệ")
    void testChangePasswordInvalidOldPassword() {
        String username = "testuser";
        Principal principal = () -> username;

        ChangePasswordRequest request = new ChangePasswordRequest();
        request.setOldPassword("wrongOldPass");
        request.setNewPassword("newPass");

        User existingUser = new User();
        existingUser.setUsername(username);
        existingUser.setPassword("encodedOldPass");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(existingUser));
        when(passwordEncoder.matches("wrongOldPass", "encodedOldPass")).thenReturn(false);

        AppException ex = assertThrows(AppException.class, () -> userService.changePassword(principal, request));
        assertEquals(ErrorCode.INVALID_PASSWORD, ex.getErrorCode());
    }
}