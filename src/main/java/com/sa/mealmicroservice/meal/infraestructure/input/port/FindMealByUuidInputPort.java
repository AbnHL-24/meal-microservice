package com.sa.mealmicroservice.meal.infraestructure.input.port;

import com.sa.mealmicroservice.meal.domain.MealDomain;

import java.util.UUID;

public interface FindMealByUuidInputPort {
    MealDomain findMealByUuid(UUID uuid);
}
