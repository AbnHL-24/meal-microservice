package com.sa.mealmicroservice.meal.aplication.usecase.createmeal;

import com.sa.mealmicroservice.common.UseCase;
import com.sa.mealmicroservice.meal.domain.MealDomain;
import com.sa.mealmicroservice.meal.infraestructure.input.port.CreateMealInputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.adapter.db.MealDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateMealUseCase implements CreateMealInputPort {
    private final MealDbEntityOutputAdapter mealDbEntityOutputAdapter;

    @Override
    public MealDomain createMeal(CreateMealRequestDto createMealRequestDto) {
        var meal = createMealRequestDto.toDomain();
        return mealDbEntityOutputAdapter.createMeal(meal);
    }
}
