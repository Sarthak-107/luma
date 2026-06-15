package com.project.luma.service.impl;

import com.project.luma.dto.subscription.PlanLimitsResponse;
import com.project.luma.dto.subscription.UsageTodayResponse;
import com.project.luma.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
