package com.bangvan.efyp.service;

import com.bangvan.efyp.dto.request.project.CreateProjectRequest;
import com.bangvan.efyp.dto.request.project.UpdateProjectRequest;
import com.bangvan.efyp.dto.response.PageCustomResponse;
import com.bangvan.efyp.dto.response.project.ProjectResponse;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    ProjectResponse createProject (CreateProjectRequest request);

    ProjectResponse updateProject(Long projectId, UpdateProjectRequest request);

    String deleteProject(Long projectId);

    ProjectResponse findProjectById(Long projectId);

    PageCustomResponse<ProjectResponse> findAllProjects(Pageable pageable);
}
