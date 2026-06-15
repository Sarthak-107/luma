package com.project.luma.mapper;

import com.project.luma.dto.project.ProjectResponse;
import com.project.luma.dto.project.ProjectSummaryResponse;
import com.project.luma.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
