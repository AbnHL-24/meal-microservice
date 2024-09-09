package com.sa.mealmicroservice.meal.infraestructure.input.adapter.restapi;


import com.sa.mealmicroservice.meal.domain.MealDomain;

import java.util.UUID;

public record MealResponse(
        UUID mealId,
        String name,
        double cost,
        String values,
        String recipe
) {

    public static MealResponse from(MealDomain meal) {
        return new MealResponse(
                meal.getMealId(),
                meal.getMealName(),
                meal.getCost(),
                meal.getIngredients(),
                meal.getRecipe()
        );
    }
}
