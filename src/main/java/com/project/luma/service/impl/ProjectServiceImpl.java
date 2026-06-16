package com.project.luma.service.impl;

import com.project.luma.dto.project.ProjectRequest;
import com.project.luma.dto.project.ProjectResponse;
import com.project.luma.dto.project.ProjectSummaryResponse;
import com.project.luma.entity.Project;
import com.project.luma.entity.User;
import com.project.luma.error.ResourceNotFoundException;
import com.project.luma.mapper.ProjectMapper;
import com.project.luma.repository.ProjectRepository;
import com.project.luma.repository.UserRepository;
import com.project.luma.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;


    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getuserProjects(Long userId) {
        return projectMapper.toListOfProjectSummaryResponse(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getProjectById(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long projectId, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to delete");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    private Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
