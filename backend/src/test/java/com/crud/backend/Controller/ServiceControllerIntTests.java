package com.crud.backend.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import com.crud.backend.controller.ServiceController;
import com.crud.backend.model.Services;
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
import org.springframework.web.server.ResponseStatusException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ServiceControllerIntTests {

    private static Services service1;
    private static Services service2;

    @Mock
    private ServicesService servicesService;

    @InjectMocks
    private ServiceController serviceController;

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
        Mockito.when(servicesService.getAll()).thenReturn(Arrays.asList());
        assertEquals(serviceController.GetServices().size(), 0);
        Mockito.verify(servicesService, Mockito.times(1)).getAll();

    }

    @Test
    void serviceTest____WithRecord() {
        Mockito.when(servicesService.getAll()).thenReturn(Arrays.asList(service1, service2));
        assertEquals(serviceController.GetServices().size(), 2);
        Mockito.verify(servicesService, Mockito.times(1)).getAll();
    }

    @Test
    void serviceTest____WithRecommendedService() {
        Mockito.when(servicesService.getRecommendedList()).thenReturn(Arrays.asList(service1, service2));
        assertEquals(serviceController.GetRecommendeServices().size(), 2);
        Mockito.verify(servicesService, Mockito.times(1)).getRecommendedList();
    }

    @Test
    void serviceTest____WithId() {
        Mockito.when(servicesService.getById("f9f8bd08-4942-4510-9bd1-d47f6455d483")).thenReturn(service1);
        Services service = serviceController.GetService("f9f8bd08-4942-4510-9bd1-d47f6455d483");
        assertEquals(service, service1);
    }

    @Test
    void serviceTest___WithNoMatch() {
        Mockito.when(servicesService.getById("f9f8bd08-4942-4510-9bd1-d47f6455d485")).thenReturn(null);
        Throwable exception = assertThrows(ResponseStatusException.class,
                () -> serviceController.GetService("f9f8bd08-4942-4510-9bd1-d47f6455d485"));
        assertEquals("404 NOT_FOUND \"Service Not Found\"", exception.getMessage());
    }

}
