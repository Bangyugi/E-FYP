package com.bangvan.efyp.dto.request.project;

import com.bangvan.efyp.utils.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String abstractive;

    @NotBlank
    private String thumbnail;

    @NotBlank
    private LocalDate summissionDate;


    private String projectInformation;

    private String repositoryUrl;

    private String post;

    @NotBlank
    private String authorName;

    @NotBlank
    private String advisorName;


    private Long authorId;

    private Long advisorId;

    @NotBlank
    private String category;

    private Set<String> tags = new HashSet<>();


    private Set<String> technologies = new HashSet<>();
}
