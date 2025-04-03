package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.dto.request.project.CreateProjectRequest;
import com.bangvan.efyp.dto.request.project.UpdateProjectRequest;
import com.bangvan.efyp.dto.response.PageCustomResponse;
import com.bangvan.efyp.dto.response.project.ProjectResponse;
import com.bangvan.efyp.entity.*;
import com.bangvan.efyp.exception.AppException;
import com.bangvan.efyp.exception.ErrorCode;
import com.bangvan.efyp.repository.*;
import com.bangvan.efyp.service.ProjectService;
import com.bangvan.efyp.utils.Status;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final TechnologyRepository technologyRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProjectResponse createProject(CreateProjectRequest request) {
        Project project = modelMapper.map(request, Project.class);
        if (!request.getCategory().isBlank()) {
            Category category = categoryRepository.findByName(request.getCategory()).orElseGet(
                    () -> {
                        Category newCategory = new Category();
                        newCategory.setName(request.getCategory());
                        return categoryRepository.save(newCategory);
                    }
            );
            project.setCategory(category);
        }
        if (!request.getTechnologies().isEmpty()) {
            Set<Technology> technologies = new HashSet<>();
            request.getTechnologies().forEach(technology -> {
                Technology iTechnology = technologyRepository.findByName(technology).orElseGet(
                        () -> {
                            Technology newTechnology = new Technology();
                            newTechnology.setName(technology);
                            return technologyRepository.save(newTechnology);
                        }
                );
                technologies.add(iTechnology);
            });
            project.setTechnologies(technologies);
        }

        if (!request.getTags().isEmpty()) {
            Set<Tag> tags = new HashSet<>();
            request.getTags().forEach(tag -> {
                Tag itag = tagRepository.findByName(tag).orElseGet(
                        () -> {
                            Tag newTag = new Tag();
                            newTag.setName(tag);
                            return tagRepository.save(newTag);
                        }
                );
                tags.add(itag);
            });
            project.setTags(tags);
        }

        if (request.getAuthorId() != null) {
            User student = userRepository.findById(request.getAuthorId()).orElseThrow(() -> new
                    AppException(ErrorCode.USER_NOT_FOUND));
            if (!(student instanceof Student)) {
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
            }
            project.setAuthor(student);
        }

        if (request.getAdvisorId() != null) {
            User advisor = userRepository.findById(request.getAdvisorId()).orElseThrow(() -> new
                    AppException(ErrorCode.USER_NOT_FOUND));
            if (!(advisor instanceof Advisor)) {
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
            }
            project.setAdvisor(advisor);
        }

        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectResponse.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProjectResponse updateProject(Long projectId, UpdateProjectRequest request) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new AppException(ErrorCode.PROJECT_NOT_FOUND));
        modelMapper.map(request, project);
        if (!request.getCategory().isBlank()) {
            Category category = categoryRepository.findByName(request.getCategory()).orElseGet(
                    () -> {
                        Category newCategory = new Category();
                        newCategory.setName(request.getCategory());
                        return categoryRepository.save(newCategory);
                    }
            );
            project.setCategory(category);
        }
        if (!request.getTechnologies().isEmpty()) {
            Set<Technology> technologies = new HashSet<>();
            request.getTechnologies().forEach(technology -> {
                Technology iTechnology = technologyRepository.findByName(technology).orElseGet(
                        () -> {
                            Technology newTechnology = new Technology();
                            newTechnology.setName(technology);
                            return technologyRepository.save(newTechnology);
                        }
                );
                technologies.add(iTechnology);
            });
            project.setTechnologies(technologies);
        }

        if (!request.getTags().isEmpty()) {
            Set<Tag> tags = new HashSet<>();
            request.getTags().forEach(tag -> {
                Tag itag = tagRepository.findByName(tag).orElseGet(
                        () -> {
                            Tag newTag = new Tag();
                            newTag.setName(tag);
                            return tagRepository.save(newTag);
                        }
                );
                tags.add(itag);
            });
            project.setTags(tags);
        }

        if (request.getAuthorId() != null) {
            User student = userRepository.findById(request.getAuthorId()).orElseThrow(() -> new
                    AppException(ErrorCode.USER_NOT_FOUND));
            if (!(student instanceof Student)) {
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
            }
            project.setAuthor(student);
        }

        if (request.getAdvisorId() != null) {
            User advisor = userRepository.findById(request.getAdvisorId()).orElseThrow(() -> new
                    AppException(ErrorCode.USER_NOT_FOUND));
            if (!(advisor instanceof Advisor)) {
                throw new AppException(ErrorCode.INVALID_USER_TYPE);
            }
            project.setAdvisor(advisor);
        }

        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectResponse.class);

    }

    @Override
    public String deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new AppException(ErrorCode.PROJECT_NOT_FOUND));
        project.setStatus(Status.DELETED);
        projectRepository.save(project);
        return "project with "+ projectId +" was deleted successfully";
    }

    @Override
    public ProjectResponse findProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new AppException(ErrorCode.PROJECT_NOT_FOUND));
        return modelMapper.map(project, ProjectResponse.class);
    }

    @Override
    public PageCustomResponse<ProjectResponse> findAllProjects(Pageable pageable) {
        Page<Project> page = projectRepository.findAll(pageable);
        return PageCustomResponse.<ProjectResponse>builder()
                .pageNo(page.getNumber()+1)
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageContent(page.getContent().stream().map(
                        project -> modelMapper.map(project, ProjectResponse.class)
                ).toList())
                .build();

    }


}
