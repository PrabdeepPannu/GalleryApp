package com.crud.backend.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.Arrays;

import com.crud.backend.controller.GraphController;
import com.crud.backend.model.Graph;
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
import org.springframework.web.server.ResponseStatusException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class GraphControllerInitTests {

    private static Graph graphTest1;
    private static Graph graphTest2;

    @Mock
    private GraphService graphService;

    @InjectMocks
    private GraphController graphController;

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
        Mockito.when(graphService.getAll()).thenReturn(Arrays.asList());
        assertEquals(graphController.GetData().size(), 0);
        Mockito.verify(graphService, Mockito.times(1)).getAll();

    }

    @Test
    void modelTestTest____WithRecord() {
        Mockito.when(graphService.getAll()).thenReturn(Arrays.asList(graphTest1, graphTest2));
        assertEquals(graphController.GetData().size(), 2);
        Mockito.verify(graphService, Mockito.times(1)).getAll();
    }

    @Test
    void modelTestTest____WithId() {
        Mockito.when(graphService.getById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0")).thenReturn(graphTest1);
        Graph graph = graphController.GetDataById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        assertEquals(graph, graphTest1);
    }

    @Test
    void modelTestTest___WithNoMatch() {
        Mockito.when(graphService.getById("f9f8bd08-4942-4510-9bd1-d47f6455d485")).thenReturn(null);
        Throwable exception = assertThrows(ResponseStatusException.class,
                () -> graphController.GetDataById("f9f8bd08-4942-4510-9bd1-d47f6455d485"));
        assertEquals("404 NOT_FOUND \"Graph Not Found\"", exception.getMessage());
    }

}
