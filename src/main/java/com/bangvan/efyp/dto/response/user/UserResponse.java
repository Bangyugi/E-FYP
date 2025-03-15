package com.bangvan.efyp.dto.response.user;

import com.bangvan.efyp.entity.Role;
import com.bangvan.efyp.utils.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponse {
    Long userId;
    String username;
    String email;
    String phone;
    String firstName;
    String lastName;
    String avatar;
    Gender gender;
    Boolean enabled;
    RoleResponse role;
}
