package com.phuongheh.services;

import com.phuongheh.commands.IngredientCommand;
import com.phuongheh.converters.IngredientCommandToIngredient;
import com.phuongheh.converters.IngredientToIngredientCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId) {
        return null;
    }

    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        return null;
    }

    @Override
    public void deleteById(String recipeId, String idToDelete) {

    }
}
