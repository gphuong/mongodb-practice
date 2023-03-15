package com.phuongheh.converters;

import com.phuongheh.commands.UnitOfMeasureCommand;
import com.phuongheh.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UnitOfMeasureToUnitOfMeasureCommandTest {    public static final String DESCRIPTION = "description";
    public static final String LONG_VALUE = "1";
    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        UnitOfMeasure command = new UnitOfMeasure();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        UnitOfMeasureCommand uom = converter.convert(command);

        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}
