
package com.crud.backend.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import com.crud.backend.model.Graph;
import com.crud.backend.repository.GraphRepository;
import com.crud.backend.service.GraphService;

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
public class GraphServiceInitTests {

    private static Graph graphTest1;
    private static Graph graphTest2;

    @Mock
    private GraphRepository graphRepository;

    @InjectMocks
    private GraphService graphService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        graphTest1 = new Graph("9a88ed50-bd33-4d7e-b53d-b45f6752f9d7", 10000, new Date(2020, 01, 01), "");
        graphTest2 = new Graph("9a88ed50-bd33-4d7e-b53d-b45f6752f9d9", 20000.0, new Date(2020, 01, 01), "");
    }

    @Test
    void modelTestTest____NoRecord() {
        Mockito.when(graphRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(graphService.getAll().size(), 0);
        Mockito.verify(graphRepository, Mockito.times(1)).findAll();

    }

    @Test
    void modelTestTest____WithRecord() {
        Mockito.when(graphRepository.findAll()).thenReturn(Arrays.asList(graphTest1, graphTest2));
        assertEquals(graphService.getAll().size(), 2);
        Mockito.verify(graphRepository, Mockito.times(1)).findAll();
    }

    @Test
    void modelTestTest____WithId() {
        Mockito.when(graphRepository.findById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0"))
                .thenReturn(Optional.of(graphTest1));
        Graph graph = graphService.getById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        assertEquals(graph, graphTest1);
    }

}
