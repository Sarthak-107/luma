package com.project.luma.service;

import com.project.luma.dto.project.ProjectRequest;
import com.project.luma.dto.project.ProjectResponse;
import com.project.luma.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getuserProjects(Long userId);

    ProjectResponse getProjectById(Long projectId, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
