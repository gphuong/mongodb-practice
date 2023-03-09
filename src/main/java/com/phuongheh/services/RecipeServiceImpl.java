package com.phuongheh.services;

import com.phuongheh.commands.RecipeCommand;
import com.phuongheh.converters.RecipeCommandToRecipe;
import com.phuongheh.domain.Recipe;
import com.phuongheh.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private  final RecipeCommandToRecipe recipeCommandToRecipe;
    @Override
    public Set<Recipe> getRecipes() {
        return null;
    }

    @Override
    public Recipe findById(String id) {
        return null;
    }

    @Override
    public RecipeCommand findCommandById(String id) {
        return null;
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        return null;
    }

    @Override
    public void deleteById(String idToDelete) {

    }
}
