package com.sa.mealmicroservice.meal.infraestructure.input.port;

import com.sa.mealmicroservice.meal.domain.MealDomain;

import java.util.List;

public interface ListMealInputPort {
    List<MealDomain> listMeal();
}