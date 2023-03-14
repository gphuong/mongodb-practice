package com.phuongheh.converters;

import com.phuongheh.domain.Recipe;
import org.junit.Before;

import java.math.BigDecimal;

public class IngredientToIngredientCommandTest {
    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final String UOM_ID = "2";
    public static final String ID_VALUE = "1";

    IngredientToIngredientCommand converter;
    @Before
    public void setUp(){
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

}
