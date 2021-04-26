package com.crud.backend.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import com.crud.backend.controller.MetricController;
import com.crud.backend.model.Metric;
import com.crud.backend.service.MetricService;

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
public class MetricControllerInitTests {

    private static Metric metric1;
    private static Metric metric2;

    @Mock
    private MetricService metricService;

    @InjectMocks
    private MetricController metricController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        metric1 = new Metric("69a8654b-eee2-49c4-b53f-0b2b8006a8a0", "facebook - Hansen-Metric-0", "metric", 14);
        metric2 = new Metric("6af12206-0a7b-4197-88a7-02f53f390811", "facebook - Hansen-Metric-0", "metric", 14);
    }

    @Test
    void metricTest____NoRecord() {
        Mockito.when(metricService.getAll()).thenReturn(Arrays.asList());
        assertEquals(metricController.GetMetrics().size(), 0);
        Mockito.verify(metricService, Mockito.times(1)).getAll();

    }

    @Test
    void metricTest____WithRecord() {
        Mockito.when(metricService.getAll()).thenReturn(Arrays.asList(metric1, metric2));
        assertEquals(metricController.GetMetrics().size(), 2);
        Mockito.verify(metricService, Mockito.times(1)).getAll();
    }

    @Test
    void metricTest____WithRecommendedService() {
        Mockito.when(metricService.getRecommendedList()).thenReturn(Arrays.asList(metric1, metric2));
        assertEquals(metricController.GetRecommendeMetrics().size(), 2);
        Mockito.verify(metricService, Mockito.times(1)).getRecommendedList();
    }

    @Test
    void metricTest____WithId() {
        Mockito.when(metricService.getById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0")).thenReturn(metric1);
        Metric metric = metricController.GetMetric("69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        assertEquals(metric, metric1);
    }

    @Test
    void metricTest___WithNoMatch() {
        Mockito.when(metricService.getById("f9f8bd08-4942-4510-9bd1-d47f6455d485")).thenReturn(null);
        Throwable exception = assertThrows(ResponseStatusException.class,
                () -> metricController.GetMetric("f9f8bd08-4942-4510-9bd1-d47f6455d485"));
        assertEquals("404 NOT_FOUND \"Metric Not Found\"", exception.getMessage());
    }

}
