package com.sa.mealmicroservice.meal.domain;

import com.sa.clientmicroservice.common.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@DomainEntity
public class MealDomain {

    private UUID mealId;
    private String mealName;
    private double cost;
    private String ingredients;
    private String recipe;
}
