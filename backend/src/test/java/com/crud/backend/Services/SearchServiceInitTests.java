package com.crud.backend.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.model.Services;
import com.crud.backend.repository.SearchRepository;
import com.crud.backend.service.SearchService;

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
public class SearchServiceInitTests {

    private static Model modelTest1;
    private static Model modelTest2;
    private static Metric metric1;
    private static Metric metric2;
    private static Services service1;
    private static Services service2;

    @Mock
    private SearchRepository searchRepository;

    @InjectMocks
    private SearchService searchService;

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
        metric1 = new Metric("69a8654b-eee2-49c4-b53f-0b2b8006a8a0", "facebook - Hansen-Metric-0", "metric", 14);
        metric2 = new Metric("6af12206-0a7b-4197-88a7-02f53f390811", "facebook - Hansen-Metric-0", "metric", 14);
        service1 = new Services("f9f8bd08-4942-4510-9bd1-d47f6455d483", "Tiktok", "service", "");
        service2 = new Services("d532906a-9576-4e3c-9d1f-1a4829efa8bd", "facebook", "service", "");
    }

    @Test
    void searchTest____NoModelName() {
        Mockito.when(searchRepository.getModelByName(null)).thenReturn(Arrays.asList());
        assertEquals(searchService.getModels(null).size(), 0);
        Mockito.verify(searchRepository, Mockito.times(1)).getModelByName(null);

    }

    @Test
    void searchTest____NoMetricName() {
        Mockito.when(searchRepository.getMetricByName(null)).thenReturn(Arrays.asList());
        assertEquals(searchService.getMetrics(null).size(), 0);
        Mockito.verify(searchRepository, Mockito.times(1)).getMetricByName(null);

    }

    @Test
    void searchTest____NoServiceName() {
        Mockito.when(searchRepository.getServiceByName(null)).thenReturn(Arrays.asList());
        assertEquals(searchService.getServices(null).size(), 0);
        Mockito.verify(searchRepository, Mockito.times(1)).getServiceByName(null);

    }

    @Test
    void searchTest____ByModelName() {
        Mockito.when(searchRepository.getModelByName("facebook")).thenReturn(Arrays.asList(modelTest1, modelTest2));
        assertEquals(searchService.getModels("facebook").size(), 2);
        Mockito.verify(searchRepository, Mockito.times(1)).getModelByName("facebook");
    }

    @Test
    void searchTest____ByMetricName() {
        Mockito.when(searchRepository.getMetricByName("facebook")).thenReturn(Arrays.asList(metric1, metric2));
        assertEquals(searchService.getMetrics("facebook").size(), 2);
        Mockito.verify(searchRepository, Mockito.times(1)).getMetricByName("facebook");
    }

    @Test
    void searchTest____ByServiceName() {
        Mockito.when(searchRepository.getServiceByName("facebook")).thenReturn(Arrays.asList(service1, service2));
        assertEquals(searchService.getServices("facebook").size(), 2);
        Mockito.verify(searchRepository, Mockito.times(1)).getServiceByName("facebook");
    }

}
