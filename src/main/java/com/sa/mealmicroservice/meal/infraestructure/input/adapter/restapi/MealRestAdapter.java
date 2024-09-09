package com.sa.mealmicroservice.meal.infraestructure.input.adapter.restapi;

import com.sa.mealmicroservice.meal.aplication.usecase.createmeal.CreateMealRequestDto;
import com.sa.mealmicroservice.meal.aplication.usecase.createmeal.CreateMealUseCase;
import com.sa.mealmicroservice.meal.aplication.usecase.findmeal.FindMealUseCase;
import com.sa.mealmicroservice.meal.aplication.usecase.listmeal.ListMealUseCase;
import com.sa.mealmicroservice.meal.aplication.usecase.updatemeal.UpdateMealRequestDto;
import com.sa.mealmicroservice.meal.infraestructure.input.port.CreateMealInputPort;
import com.sa.mealmicroservice.meal.infraestructure.input.port.FindMealByUuidInputPort;
import com.sa.mealmicroservice.meal.infraestructure.input.port.ListMealInputPort;
import com.sa.mealmicroservice.meal.infraestructure.input.port.UpdateMealInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sa.mealmicroservice.common.WebAdapter;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@WebAdapter
@RequestMapping("/V1/meals")
@RequiredArgsConstructor
public class MealRestAdapter {

    private final CreateMealInputPort createMealUseCase;
    private final UpdateMealInputPort updateMealUseCase;
    private final ListMealInputPort listMealUseCase;
    private final FindMealByUuidInputPort findMealUseCase;

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

    @PutMapping("/{uuid}")
    public ResponseEntity<MealResponse> updateMeal(@PathVariable UUID uuid, @RequestBody @Valid UpdateMealRequestDto updateMealRequestDto) {
        var mealUpdated = updateMealUseCase.updateMeal(uuid, updateMealRequestDto);

        return ResponseEntity.ok(MealResponse.from(mealUpdated));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<MealResponse> getMeal(@PathVariable UUID uuid) {
        var mealFinded = findMealUseCase.findMealByUuid(uuid);
        return ResponseEntity.ok(MealResponse.from(mealFinded));
    }
}
