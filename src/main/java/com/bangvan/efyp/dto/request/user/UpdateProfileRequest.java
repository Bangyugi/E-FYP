package com.bangvan.efyp.dto.request.user;


import com.bangvan.efyp.utils.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UpdateProfileRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String birthDate;

    private String avatar ="https://cdn-icons-png.flaticon.com/512/3607/3607444.png";

    private Gender gender;


    // Trường này dùng để phân biệt loại user (STUDENT, ADVISOR, USER)
    @NotBlank
    private String userType;

    // Các trường bổ sung dành riêng cho Student
    private String majorName;
    private LocalDate GraduationTime;

    // Các trường bổ sung dành riêng cho Advisor
    private String facultyName;
    private String academicDegree;

}

