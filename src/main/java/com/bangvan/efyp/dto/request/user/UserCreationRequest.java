package com.bangvan.efyp.dto.request.user;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserCreationRequest {
    String username;
    String password;
    String email;
    String phone;
    String firstName;
    String lastName;
    String gender;
}
