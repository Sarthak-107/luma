package com.project.luma.dto.member;

import com.project.luma.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
