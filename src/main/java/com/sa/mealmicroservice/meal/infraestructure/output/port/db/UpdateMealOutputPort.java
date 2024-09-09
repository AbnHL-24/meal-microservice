package com.sa.mealmicroservice.meal.infraestructure.output.port.db;

import com.sa.mealmicroservice.meal.domain.MealDomain;

public interface UpdateMealOutputPort {
    MealDomain updateMeal(MealDomain mealD);
}
