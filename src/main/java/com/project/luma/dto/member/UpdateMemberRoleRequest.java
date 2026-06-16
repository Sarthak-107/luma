package com.project.luma.dto.member;

import com.project.luma.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole role) {
}
