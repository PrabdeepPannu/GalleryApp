package com.crud.backend.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import com.crud.backend.controller.ModelController;
import com.crud.backend.model.Model;
import com.crud.backend.service.ModelService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ModelControllerInitTests {

    private static Model modelTest1;
    private static Model modelTest2;

    @Mock
    private ModelService modelService;

    @InjectMocks
    private ModelController modelController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        modelTest1 = new Model("048de4ab-5740-4fe0-954a-20a7350a6e1c", "facebook - Likes Modelled Data", "model",
                "test", "test", "", "");
        modelTest2 = new Model("048de4ab-5740-4fe0-954a-20a7350a6e1c", "facebook - Likes Modelled Data", "model",
                "test", "test", "", "");
    }

    @Test
    void modelTest____NoRecord() {
        Mockito.when(modelService.getAll()).thenReturn(Arrays.asList());
        assertEquals(modelController.GetModels().size(), 0);
        Mockito.verify(modelService, Mockito.times(1)).getAll();

    }

    @Test
    void modelTest____WithRecord() {
        Mockito.when(modelService.getAll()).thenReturn(Arrays.asList(modelTest1, modelTest2));
        assertEquals(modelController.GetModels().size(), 2);
        Mockito.verify(modelService, Mockito.times(1)).getAll();
    }

    @Test
    void modelTest____WithRecommendedService() {
        Mockito.when(modelService.getRecommendedList()).thenReturn(Arrays.asList(modelTest1, modelTest2));
        assertEquals(modelController.GetRecommendeModels().size(), 2);
        Mockito.verify(modelService, Mockito.times(1)).getRecommendedList();
    }

    @Test
    void modelTest____WithId() {
        Mockito.when(modelService.getById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0")).thenReturn(modelTest1);
        Model model = modelController.GetModel("69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        assertEquals(model, modelTest1);
    }

    @Test
    void modelTest___WithNoMatch() {
        Mockito.when(modelService.getById("f9f8bd08-4942-4510-9bd1-d47f6455d485")).thenReturn(null);
        Throwable exception = assertThrows(ResponseStatusException.class,
                () -> modelController.GetModel("f9f8bd08-4942-4510-9bd1-d47f6455d485"));
        assertEquals("404 NOT_FOUND \"Model Not Found\"", exception.getMessage());
    }

}
