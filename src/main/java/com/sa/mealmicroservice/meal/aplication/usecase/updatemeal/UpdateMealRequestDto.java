package com.sa.mealmicroservice.meal.aplication.usecase.updatemeal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateMealRequestDto(
        @NotEmpty(message = "Meal's UUID is required.")
        //@Size()
        UUID mealId,

        @NotNull(message = "The name's meal is required.")
        @Size(max = 100, message = "The full name must have a maximum of 100 characters")
        String name,

        @NotNull(message = "The cost is required")
        @Size(max = 10, message = "The cost must have a maximum of 10 units and 2 decimals")
        Double cost,

        @NotEmpty(message = "Ingredients are required for made a meal.")
        @Size(max = 500, message = "The max of ingredients can be describe in 500 letters.")
        String ingredients,

        @NotEmpty(message = "The recipe are necesary to made the meal.")
        @Size(max = 1000, message = "The recipe must be written in 1000 characters")
        String recipe
) {
}
