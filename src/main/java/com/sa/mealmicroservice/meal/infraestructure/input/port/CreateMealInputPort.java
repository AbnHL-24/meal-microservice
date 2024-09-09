package com.sa.mealmicroservice.meal.infraestructure.input.port;

import com.sa.mealmicroservice.meal.aplication.usecase.createmeal.CreateMealRequestDto;
import com.sa.mealmicroservice.meal.domain.MealDomain;

public interface CreateMealInputPort {
    MealDomain createMeal(CreateMealRequestDto createMealRequestDto);
}
