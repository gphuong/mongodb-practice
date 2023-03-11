package com.phuongheh.converters;

import com.mongodb.lang.Nullable;
import com.phuongheh.commands.UnitOfMeasureCommand;
import com.phuongheh.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Override
    @Synchronized
    @Nullable
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source != null) {
            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
            uomc.setId(source.getId());
            uomc.setDescription(source.getDescription());
            return uomc;
        }
        return null;
    }
}
