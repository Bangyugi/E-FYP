package com.bangvan.efyp.dto.response.user;

import com.bangvan.efyp.entity.Faculty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorResponse extends UserResponse {
    private String academicDegree;
    private Faculty faculty;
}
