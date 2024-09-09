package com.sa.mealmicroservice.meal.infraestructure.input.port;

import com.sa.mealmicroservice.meal.domain.MealDomain;

public interface FindMealByUuidInputPort {
    MealDomain findMealByUuid(String uuid);
}
