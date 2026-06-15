package com.project.luma.entity;

import com.project.luma.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Subscription {
    Long id;
    User user;
    Plan plan;
    String stripeCustomerId;
    String stripeSubscriptionId;
    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd = false;
    SubscriptionStatus status;
    Instant createdAt;
    Instant updatedAt;
}
