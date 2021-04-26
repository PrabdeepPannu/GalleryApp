package com.crud.backend.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import com.crud.backend.model.Services;
import com.crud.backend.repository.ServiceRepository;
import com.crud.backend.service.ServicesService;

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
public class ServicesServiceInitTests {

    private static Services service1;
    private static Services service2;

    @Mock
    private ServiceRepository serviceRepository;

    @InjectMocks
    private ServicesService servicesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        service1 = new Services("f9f8bd08-4942-4510-9bd1-d47f6455d483", "Tiktok", "service", "");
        service2 = new Services("d532906a-9576-4e3c-9d1f-1a4829efa8bd", "facebook", "service", "");
    }

    @Test
    void serviceTest____NoRecord() {
        Mockito.when(serviceRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(servicesService.getAll().size(), 0);
        Mockito.verify(serviceRepository, Mockito.times(1)).findAll();

    }

    @Test
    void serviceTest____WithRecord() {
        Mockito.when(serviceRepository.findAll()).thenReturn(Arrays.asList(service1, service2));
        assertEquals(servicesService.getAll().size(), 2);
        Mockito.verify(serviceRepository, Mockito.times(1)).findAll();
    }

    @Test
    void serviceTest____WithRecommendedService() {
        Mockito.when(serviceRepository.getRecommendedServices()).thenReturn(Arrays.asList(service1, service2));
        assertEquals(servicesService.getRecommendedList().size(), 2);
        Mockito.verify(serviceRepository, Mockito.times(1)).getRecommendedServices();
    }

}
