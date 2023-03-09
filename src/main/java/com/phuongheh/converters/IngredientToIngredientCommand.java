package com.phuongheh.converters;

import com.mongodb.lang.Nullable;
import com.phuongheh.commands.IngredientCommand;
import com.phuongheh.commands.UnitOfMeasureToUnitOfMeasureCommand;
import com.phuongheh.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.converter = converter;
    }

    @Override
    @Synchronized
    @Nullable
    public IngredientCommand convert(Ingredient source) {
        if (source == null)
            return null;
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        if (source.getRecipe() != null)
            ingredientCommand.setRecipeId(source.getRecipe().getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUom(converter.convert(source.getUom()));
        return ingredientCommand;
    }
}
