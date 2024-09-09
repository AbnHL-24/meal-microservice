package com.sa.mealmicroservice.meal.infraestructure.output.adapter.db;

import com.sa.mealmicroservice.meal.domain.MealDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meal")
public class MealDbEntity {
    @Id
    private UUID mealId;

    @Column
    private String mealName;

    @Column
    private Double mealCost;

    @Column
    private String ingredients;

    @Column
    private String recipe;

    private static MealDbEntity fromDomain(MealDomain meal) {
        return new MealDbEntity(
                UUID.randomUUID(),
                meal.getMealName(),
                meal.getCost(),
                meal.getIngredients(),
                meal.getRecipe()
        );
    }

    private MealDomain toDomain() {
        return MealDomain.builder()
                .mealId(mealId)
                .mealName(mealName)
                .cost(mealCost)
                .ingredients(ingredients)
                .recipe(recipe)
                .build();
    }
}
