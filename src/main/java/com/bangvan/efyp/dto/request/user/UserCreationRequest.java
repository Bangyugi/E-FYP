package com.bangvan.efyp.dto.request.user;


import com.bangvan.efyp.utils.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserCreationRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

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

    private String avatar;

    private Gender gender;

    @NotNull
    private Boolean enabled;

    // Trường này dùng để phân biệt loại user (STUDENT, ADVISOR, ADMIN, SUPERADMIN)
    @NotBlank
    private String userType;

    private String roles;

    // Các trường bổ sung dành riêng cho Student
    private String majorName;
    private Integer graduationYear;

    // Các trường bổ sung dành riêng cho Advisor
    private String facultyName;
    private String academicDegree;


}
