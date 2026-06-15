package com.project.luma.service.impl;

import com.project.luma.dto.subscription.PlanResponse;
import com.project.luma.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
