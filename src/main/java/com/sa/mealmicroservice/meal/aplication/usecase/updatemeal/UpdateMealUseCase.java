package com.sa.mealmicroservice.meal.aplication.usecase.updatemeal;

import com.sa.mealmicroservice.common.UseCase;
import com.sa.mealmicroservice.meal.domain.MealDomain;
import com.sa.mealmicroservice.meal.infraestructure.input.port.ListMealInputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.adapter.db.MealDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@UseCase
@RequiredArgsConstructor
public class UpdateMealUseCase implements ListMealInputPort {

    private final MealDbEntityOutputAdapter mealDbEntityOutputAdapter;

    @Override
    public List<MealDomain> listMeal() {
        return mealDbEntityOutputAdapter.listMeals();
    }
}
