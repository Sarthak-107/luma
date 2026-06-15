package com.project.luma.service.impl;

import com.project.luma.dto.auth.AuthResponse;
import com.project.luma.dto.auth.LoginRequest;
import com.project.luma.dto.auth.SignupRequest;
import com.project.luma.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
