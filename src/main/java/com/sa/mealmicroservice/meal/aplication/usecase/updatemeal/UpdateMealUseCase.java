package com.sa.mealmicroservice.meal.aplication.usecase.updatemeal;

import com.sa.mealmicroservice.common.UseCase;
import com.sa.mealmicroservice.meal.aplication.usecase.createmeal.CreateMealRequestDto;
import com.sa.mealmicroservice.meal.domain.MealDomain;
import com.sa.mealmicroservice.meal.infraestructure.input.port.UpdateMealInputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.adapter.db.MealDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdateMealUseCase implements UpdateMealInputPort {

    private final MealDbEntityOutputAdapter mealDbEntityOutputAdapter;

    @Override
    public MealDomain updateMeal(UUID mealId, UpdateMealRequestDto updateMealRequestDto) {
        var Meal = updateMealRequestDto.toDomain();
        return mealDbEntityOutputAdapter.updateMeal(Meal);
    }
}
