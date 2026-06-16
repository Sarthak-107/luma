package com.project.luma.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignupRequest(
       @Email @NotNull String email,
       @Size(min = 3, max = 30) String name,
       @Size(min = 4, max = 20) String password
) {
}
