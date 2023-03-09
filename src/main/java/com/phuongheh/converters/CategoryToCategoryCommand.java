package com.phuongheh.converters;

import com.mongodb.lang.Nullable;
import com.phuongheh.commands.CategoryCommand;
import com.phuongheh.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Override
    @Synchronized
    @Nullable
    public CategoryCommand convert(Category source) {
        if (source == null)
            return null;
        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        return categoryCommand;
    }
}
