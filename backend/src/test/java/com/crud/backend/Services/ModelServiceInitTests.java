package com.crud.backend.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import com.crud.backend.model.Model;
import com.crud.backend.repository.ModelRepository;
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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ModelServiceInitTests {

    private static Model modelTest1;
    private static Model modelTest2;

    @Mock
    private ModelRepository modelRepository;

    @InjectMocks
    private ModelService modelService;

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
        Mockito.when(modelRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(modelService.getAll().size(), 0);
        Mockito.verify(modelRepository, Mockito.times(1)).findAll();

    }

    @Test
    void modelTest____WithRecord() {
        Mockito.when(modelRepository.findAll()).thenReturn(Arrays.asList(modelTest1, modelTest2));
        assertEquals(modelService.getAll().size(), 2);
        Mockito.verify(modelRepository, Mockito.times(1)).findAll();
    }

    @Test
    void modelTest____WithRecommendedService() {
        Mockito.when(modelRepository.getRecommendedModels()).thenReturn(Arrays.asList(modelTest1, modelTest2));
        assertEquals(modelService.getRecommendedList().size(), 2);
        Mockito.verify(modelRepository, Mockito.times(1)).getRecommendedModels();
    }

    @Test
    void modelTest____WithId() {
        Mockito.when(modelRepository.findById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0"))
                .thenReturn(Optional.of(modelTest1));
        Model model = modelService.getById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        assertEquals(model, modelTest1);
    }

}
