package com.bangvan.efyp.controller;

import com.bangvan.efyp.dto.request.project.CreateProjectRequest;
import com.bangvan.efyp.dto.request.project.UpdateProjectRequest;
import com.bangvan.efyp.dto.response.ApiResponse;
import com.bangvan.efyp.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@Tag(name = "Project", description = "Project API")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "Create Project", description = "Create Project")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProject(@RequestBody CreateProjectRequest request) {
        log.info("Request: {}", request);
        ApiResponse apiResponse = ApiResponse.success(201, "Project created successfully", projectService.createProject(request));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Find All Projects", description = "Find All Projects")
    @GetMapping("/find-all")
    public ResponseEntity<ApiResponse> findAllProjects(
            @RequestParam (value= "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam (value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam (value = "sortBy", defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(value="sortDir", defaultValue = "ASC", required = false) String sortDir

    ) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        ApiResponse apiResponse = ApiResponse.success(200, "Projects found successfully", projectService.findAllProjects(pageable));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation(summary = "Find Project By Id", description = "Find Project By Id")
    @GetMapping("/find/{projectId}")
    public ResponseEntity<ApiResponse> findProjectById(@PathVariable Long projectId) {
        ApiResponse apiResponse = ApiResponse.success(200, "Project found successfully", projectService.findProjectById(projectId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<ApiResponse> updateProjectById(@PathVariable Long projectId, @RequestBody UpdateProjectRequest request){
        ApiResponse apiResponse = ApiResponse.success(200, "Update project successfully",projectService.updateProject(projectId, request));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<ApiResponse> deleteProjectById(@PathVariable Long projectId) {
        ApiResponse apiResponse = ApiResponse.success(200, "Project deleted successfully", projectService.deleteProject(projectId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
