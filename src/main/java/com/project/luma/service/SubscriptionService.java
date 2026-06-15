package com.project.luma.service;

import com.project.luma.dto.subscription.CheckoutRequest;
import com.project.luma.dto.subscription.CheckoutResponse;
import com.project.luma.dto.subscription.PortalResponse;
import com.project.luma.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
