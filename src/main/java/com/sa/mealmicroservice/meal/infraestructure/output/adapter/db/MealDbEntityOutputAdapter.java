package com.sa.mealmicroservice.meal.infraestructure.output.adapter.db;

import com.sa.mealmicroservice.meal.domain.MealDomain;
import com.sa.mealmicroservice.meal.infraestructure.output.port.db.CreateMealOutputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.port.db.FindMealOutputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.port.db.ListMealOutputPort;
import com.sa.mealmicroservice.meal.infraestructure.output.port.db.UpdateMealOutputPort;
import com.sa.mealmicroservice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MealDbEntityOutputAdapter
        implements
        CreateMealOutputPort,
        FindMealOutputPort,
        ListMealOutputPort,
        UpdateMealOutputPort {

    private final MealDbEntityRepository mealDbEntityRepository;

    @Override
    public MealDomain createMeal(MealDomain meal) {
        var mealDbEntity = MealDbEntity.fromDomain(meal);
        return mealDbEntityRepository.save(mealDbEntity).toDomain();
    }

    @Override
    public Optional<MealDomain> findMealByMealId(UUID uuid) {
        // TODO revisar esta cosa.
        return mealDbEntityRepository.existsByMealId(uuid);
    }

    @Override
    public List<MealDomain> listMeals() {
        return mealDbEntityRepository.findAll()
                .stream().map(MealDbEntity::toDomain).toList();
    }

    @Override
    public MealDomain updateMeal(MealDomain mealD) {
        var mealDbEntity = MealDbEntity.fromDomain(mealD);
        return mealDbEntityRepository.save(mealDbEntity).toDomain();
    }
}
