package com.phuongheh.controllers;

import com.phuongheh.services.RecipeService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController controller;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }
}
