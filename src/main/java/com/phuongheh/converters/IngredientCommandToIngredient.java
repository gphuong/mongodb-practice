package com.phuongheh.converters;

import com.mongodb.lang.Nullable;
import com.phuongheh.commands.IngredientCommand;
import com.phuongheh.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Override
    @Synchronized
    @Nullable
    public Ingredient convert(IngredientCommand source) {
        if (source == null)
            return null;
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());

    }
}
