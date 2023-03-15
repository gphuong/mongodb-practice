package com.phuongheh.services;

import com.phuongheh.commands.RecipeCommand;
import com.phuongheh.converters.RecipeCommandToRecipe;
import com.phuongheh.converters.RecipeToRecipeCommand;
import com.phuongheh.domain.Recipe;
import com.phuongheh.exceptions.NotFoundException;
import com.phuongheh.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId("1");
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById("1");
        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() {
        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById("1");
    }

    @Test
    public void getRecipeCommandByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId("1");
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId("1");
        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);
        RecipeCommand commandById = recipeService.findCommandById("1");
        assertNotNull("Null recipe returned", commandById);
        ;
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void testRecipeTest() {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyString());
    }

    @Test
    public void testDeleteById() {
        String idToDelete = "2";
        recipeService.deleteById(idToDelete);

        verify(recipeRepository, times(1)).deleteById(anyString());

    }
}
