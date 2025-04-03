package com.bangvan.efyp.dto.response.project;

import com.bangvan.efyp.entity.Category;
import com.bangvan.efyp.entity.Tag;
import com.bangvan.efyp.entity.Technology;
import com.bangvan.efyp.entity.User;
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
public class ProjectResponse {

    private Long projectId;

    private String title;

    private String abstractive;

    private String thumbnail;

    private Status status;

    private LocalDate summissionDate;

    private Long upvote ;

    private Long downvote;


    private String projectInformation;

    private String repositoryUrl;

    private String post;

    private String authorName;

    private String advisorName;


    private User author;

    private User advisor;


    private Category category;

    private Set<Tag> tags = new HashSet<>();


    private Set<Technology> technologies = new HashSet<>();
}
