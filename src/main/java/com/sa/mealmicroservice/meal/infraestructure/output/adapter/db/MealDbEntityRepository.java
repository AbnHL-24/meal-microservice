package com.sa.mealmicroservice.meal.infraestructure.output.adapter.db;

import com.sa.mealmicroservice.meal.domain.MealDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MealDbEntityRepository extends JpaRepository<MealDbEntity, String> {
    boolean existsByMealId(Long mealId);
    Optional<MealDomain> existsByMealUuid(UUID mealUuid);
}
