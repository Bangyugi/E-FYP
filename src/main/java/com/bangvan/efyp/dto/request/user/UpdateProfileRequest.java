package com.bangvan.efyp.dto.request.user;


import com.bangvan.efyp.utils.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UpdateProfileRequest {
    String firstName;
    String lastName;
    Gender gender;
    String avatar= "https://cdn-icons-png.flaticon.com/512/3607/3607444.png";
    String email;
    String phone;
}
