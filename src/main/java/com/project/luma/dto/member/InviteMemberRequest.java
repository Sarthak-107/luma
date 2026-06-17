package com.project.luma.dto.member;

import com.project.luma.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotNull String username,
        @NotNull ProjectRole role
) {
}
