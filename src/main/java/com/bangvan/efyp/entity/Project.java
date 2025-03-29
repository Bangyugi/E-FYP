package com.bangvan.efyp.entity;

import com.bangvan.efyp.utils.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long topicId;

    @Column(name="title", nullable = false)
    private String title;


    @Column(name = "abstractive", nullable = false,columnDefinition = "TEXT")
    private String abstractive;

    @Column(name="thumbnail", columnDefinition = "TEXT")
    private String thumbnail;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "summission_date", nullable = false)
    private LocalDate summissionDate;

    @Column(name = "upvote", nullable = false)
    private Long upvote = 0L;

    @Column(name = "downvote", nullable = false)
    private Long downvote = 0L;

    @Column(name = "project_information", columnDefinition = "TEXT", nullable = false)
    private String projectInformation;

    @Column(name = "repository_url", columnDefinition = "TEXT", nullable = false)
    private String repositoryUrl;

    @Column(name = "post",columnDefinition = "TEXT", nullable = false)
    private String post;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "advisor_name", nullable = false)
    private String advisorName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "project_tag",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "project_technology",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<Technology> technologies = new HashSet<>();
}
