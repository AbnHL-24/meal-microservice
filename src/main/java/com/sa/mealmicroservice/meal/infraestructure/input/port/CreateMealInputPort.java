package com.sa.mealmicroservice.meal.infraestructure.input.port;

import com.sa.mealmicroservice.meal.domain.MealDomain;

public interface CreateMealInputPort {
    MealDomain createMeal(CreateMealInputPort createMealInputPort);
}
