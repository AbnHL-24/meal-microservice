package com.sa.mealmicroservice.meal.aplication.usecase.findmeal;

import com.sa.mealmicroservice.common.UseCase;
import com.sa.mealmicroservice.meal.domain.MealDomain;
import com.sa.mealmicroservice.meal.infraestructure.input.port.FindMealByUuidInputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.port.db.FindMealOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindMealUseCase implements FindMealByUuidInputPort {

    private final FindMealOutputPort findMealOutputPort;

    @Override
    public MealDomain findMealByUuid(UUID uuid) {
        var optional = findMealOutputPort.findMealByUuid(uuid);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
