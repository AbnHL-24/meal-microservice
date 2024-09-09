package com.sa.mealmicroservice.meal.infraestructure.input.adapter.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sa.clientmicroservice.common.WebAdapter;

import java.util.List;

@WebAdapter
@RequestMapping("/V1/meals")
@RequiredArgsConstructor
public class MealRestAdapter {

    // private final CreateMealInputPort
    // private final LisMealsInputPort l

    @GetMapping
    public RequestEntity<List<MealResponse>> listMeals() {
        return null;
    }
}
