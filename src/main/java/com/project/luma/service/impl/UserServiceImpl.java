package com.project.luma.service.impl;

import com.project.luma.dto.auth.UserProfileResponse;
import com.project.luma.dto.subscription.PlanLimitsResponse;
import com.project.luma.dto.subscription.UsageTodayResponse;
import com.project.luma.service.UsageService;
import com.project.luma.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
