package com.crud.backend.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import com.crud.backend.model.Graph;
import com.crud.backend.model.Metric;
import com.crud.backend.repository.GraphRepository;
import com.crud.backend.repository.MetricRepository;
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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MerticServiceInit {

    private static Metric metric1;
    private static Metric metric2;

    private static Graph graphTest1;
    private static Graph graphTest2;

    @Mock
    private MetricRepository metricRepository;

    @Mock
    private GraphRepository graphRepository;

    @InjectMocks
    private MetricService metricService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        metric1 = new Metric("69a8654b-eee2-49c4-b53f-0b2b8006a8a0", "facebook - Hansen-Metric-0", "metric", 14);
        metric2 = new Metric("6af12206-0a7b-4197-88a7-02f53f390811", "facebook - Hansen-Metric-0", "metric", 14);
        graphTest1 = new Graph("9a88ed50-bd33-4d7e-b53d-b45f6752f9d7", 10000, new Date(2020, 01, 01),
                "69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        graphTest2 = new Graph("9a88ed50-bd33-4d7e-b53d-b45f6752f9d9", 20000.0, new Date(2020, 01, 01),
                "69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
    }

    @Test
    void metricTest____NoRecord() {
        Mockito.when(metricRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(metricService.getAll().size(), 0);
        Mockito.verify(metricRepository, Mockito.times(1)).findAll();

    }

    @Test
    void metricTest____WithRecord() {
        Mockito.when(metricRepository.findAll()).thenReturn(Arrays.asList(metric1, metric2));
        Mockito.when(graphRepository.getGraphByMetricId("69a8654b-eee2-49c4-b53f-0b2b8006a8a0"))
                .thenReturn(Arrays.asList(graphTest1, graphTest2));
        Mockito.when(graphRepository.getGraphByMetricId("6af12206-0a7b-4197-88a7-02f53f390811"))
                .thenReturn(Arrays.asList());
        assertEquals(metricService.getAll().size(), 2);
        Mockito.verify(metricRepository, Mockito.times(1)).findAll();
    }

    @Test
    void metricTest____WithRecommendedMetric() {
        Mockito.when(metricRepository.getRecommendedMetrics()).thenReturn(Arrays.asList(metric1, metric2));
        Mockito.when(graphRepository.getGraphByMetricId("69a8654b-eee2-49c4-b53f-0b2b8006a8a0"))
                .thenReturn(Arrays.asList(graphTest1, graphTest2));
        Mockito.when(graphRepository.getGraphByMetricId("6af12206-0a7b-4197-88a7-02f53f390811"))
                .thenReturn(Arrays.asList());
        assertEquals(metricService.getRecommendedList().size(), 2);
        Mockito.verify(metricRepository, Mockito.times(1)).getRecommendedMetrics();
    }

    @Test
    void metricTest____WithId() {
        Mockito.when(metricRepository.findById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0"))
                .thenReturn(Optional.of(metric1));
        Mockito.when(graphRepository.getGraphByMetricId("69a8654b-eee2-49c4-b53f-0b2b8006a8a0"))
                .thenReturn(Arrays.asList(graphTest1, graphTest2));
        Metric metric = metricService.getById("69a8654b-eee2-49c4-b53f-0b2b8006a8a0");
        assertEquals(metric, metric1);
    }

}
