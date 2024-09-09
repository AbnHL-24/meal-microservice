package com.sa.mealmicroservice.meal.infraestructure.output.port.db;

import com.sa.mealmicroservice.meal.domain.MealDomain;

import java.util.List;

public interface ListMealOutputPort {
    List<MealDomain> listMeals();
}
