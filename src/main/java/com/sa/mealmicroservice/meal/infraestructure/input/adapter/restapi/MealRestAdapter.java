package com.sa.mealmicroservice.meal.infraestructure.input.adapter.restapi;

import com.sa.mealmicroservice.meal.aplication.usecase.createmeal.CreateMealRequestDto;
import com.sa.mealmicroservice.meal.aplication.usecase.createmeal.CreateMealUseCase;
import com.sa.mealmicroservice.meal.aplication.usecase.listmeal.ListMealUseCase;
import com.sa.mealmicroservice.meal.infraestructure.input.port.CreateMealInputPort;
import com.sa.mealmicroservice.meal.infraestructure.input.port.ListMealInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sa.mealmicroservice.common.WebAdapter;

import java.net.URI;
import java.util.List;

@WebAdapter
@RequestMapping("/V1/meals")
@RequiredArgsConstructor
public class MealRestAdapter {

    private final CreateMealInputPort createMealUseCase;
    private final ListMealInputPort listMealUseCase;

    @GetMapping
    public ResponseEntity<List<MealResponse>> listMeals() {
        var meals = listMealUseCase.listMeal()
                .stream().map(MealResponse::from).toList();
        return ResponseEntity.ok(meals);
    }
    @PostMapping
    public ResponseEntity<MealResponse> createMeal(@RequestBody @Valid CreateMealRequestDto createMealRequestDto) {
        var meal = createMealUseCase.createMeal(createMealRequestDto);

        return ResponseEntity.created(URI.create("/V1/meals/" + meal.getMealId().toString()))
                .body(MealResponse.from(meal));
    }
}
