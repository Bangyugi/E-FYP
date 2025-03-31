package com.bangvan.efyp.dto.response.user;

import com.bangvan.efyp.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse extends UserResponse {
    private LocalDate graduationTime;
    private Major major;
}
