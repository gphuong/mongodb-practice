package com.phuongheh.converters;

import com.mongodb.lang.Nullable;
import com.phuongheh.commands.UnitOfMeasureCommand;
import com.phuongheh.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Override
    @Synchronized
    @Nullable
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null)
            return null;
        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
