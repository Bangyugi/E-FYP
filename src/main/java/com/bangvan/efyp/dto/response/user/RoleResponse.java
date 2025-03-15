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
public class RoleResponse {
    Long roleId;
    String name;
    String description;
}
