package com.phuongheh.converters;


import com.phuongheh.commands.RecipeCommand;
import com.phuongheh.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    @Override
    public Recipe convert(RecipeCommand source) {
        return null;
    }
}
