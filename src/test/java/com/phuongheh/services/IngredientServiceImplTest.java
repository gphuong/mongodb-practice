package com.phuongheh.services;

import com.phuongheh.commands.IngredientCommand;
import com.phuongheh.converters.IngredientCommandToIngredient;
import com.phuongheh.converters.IngredientToIngredientCommand;
import com.phuongheh.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.phuongheh.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.phuongheh.domain.Ingredient;
import com.phuongheh.domain.Recipe;
import com.phuongheh.repositories.RecipeRepository;
import com.phuongheh.repositories.UnitOfMeasureRepository;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    IngredientService ingredientService;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void findByRecipeIdAndId() {
    }

    @Test
    public void findByRecipeIdAndRecipeIdHappyPath() {
        Recipe recipe = new Recipe();
        recipe.setId("1");

        Ingredient ingredient = new Ingredient();
        ingredient.setId("1");

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId("1");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId("3");

        recipe.addIngredient(ingredient);
        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId("1", "3");
        assertEquals("3", ingredientCommand.getId());
        assertEquals("1", ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyString());
    }

    @Test
    public void testSaveRecipeCommand() {
        IngredientCommand command = new IngredientCommand();
        command.setId("3");
        command.setRecipeId("2");

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());
        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId("3");
        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        assertEquals("3", savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    public void testDeleteById() {
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        ingredient.setId("3");
        recipe.addIngredient(ingredient);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        ingredientService.deleteById("1", "3");
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }
}
