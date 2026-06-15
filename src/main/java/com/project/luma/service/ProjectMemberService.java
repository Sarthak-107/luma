package com.project.luma.service;

import com.project.luma.dto.member.InviteMemberRequest;
import com.project.luma.dto.member.MemberResponse;
import com.project.luma.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getprojectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    void removeMember(Long projectId, Long memberId, Long userId);
}
