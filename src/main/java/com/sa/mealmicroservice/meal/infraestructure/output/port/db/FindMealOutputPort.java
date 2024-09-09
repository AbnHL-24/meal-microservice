package com.sa.mealmicroservice.meal.infraestructure.output.port.db;

import com.sa.mealmicroservice.meal.domain.MealDomain;

import java.util.Optional;
import java.util.UUID;

public interface FindMealOutputPort {
    Optional<MealDomain> findMealByMealId(UUID uuid);
}
