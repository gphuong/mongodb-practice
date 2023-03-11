package com.phuongheh.repositories;

import com.phuongheh.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Recipe, String> {
}
