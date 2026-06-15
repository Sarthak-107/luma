package com.project.luma.service.impl;

import com.project.luma.dto.member.InviteMemberRequest;
import com.project.luma.dto.member.MemberResponse;
import com.project.luma.dto.member.UpdateMemberRoleRequest;
import com.project.luma.entity.Project;
import com.project.luma.entity.ProjectMember;
import com.project.luma.entity.ProjectMemberId;
import com.project.luma.entity.User;
import com.project.luma.mapper.ProjectMemberMapper;
import com.project.luma.repository.ProjectMemberRepository;
import com.project.luma.repository.ProjectRepository;
import com.project.luma.repository.UserRepository;
import com.project.luma.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getprojectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList());

        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed, only project owner can invite people");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,userId);

        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .invitedAt(Instant.now())
                .projectRole(request.role())
                .user(invitee)
                .project(project)
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);

        if(!project.getOwner().getId().equals(userId))
        {
            throw new RuntimeException("Not allowed, only owner can update");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed, only owner can remove member");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member does not exist");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    private Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
