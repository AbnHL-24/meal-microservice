package com.sa.mealmicroservice.meal.infraestructure.output.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDbEntityRepository extends JpaRepository<MealDbEntity, String> {
    boolean existsByMealId(Long mealId);
}
