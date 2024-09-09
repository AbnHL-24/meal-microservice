package com.sa.mealmicroservice.meal.infraestructure.input.port;

import com.sa.mealmicroservice.meal.aplication.usecase.updatemeal.UpdateMealRequestDto;
import com.sa.mealmicroservice.meal.domain.MealDomain;

import java.util.UUID;

public interface UpdateMealInputPort {
    MealDomain updateMeal(UUID mealId, UpdateMealRequestDto updateMealRequestDto);
}
