package com.phuongheh.services;

import com.phuongheh.commands.UnitOfMeasureCommand;
import com.phuongheh.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.phuongheh.domain.UnitOfMeasure;
import com.phuongheh.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms(){
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId("1");
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId("2");
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);
        Set<UnitOfMeasureCommand> commands = service.listAllUoms();
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();
    }
}
