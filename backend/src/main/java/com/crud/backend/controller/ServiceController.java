package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.crud.backend.model.Services;
import com.crud.backend.service.ServicesService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping("/service")
    public List<Services> GetServices() {
        return servicesService.getAll();
    }

    @GetMapping("/service/recommended")
    public List<Services> GetRecommendeServices() {
        return servicesService.getRecommendedList();
    }

    @GetMapping("/service/{id}")
    public Services GetService(@PathVariable String id) {
        return servicesService.getById(id);
    }

    @PostMapping("/service")
    public void PostService(@RequestBody Services service) {
        servicesService.save(service);
    }

    @PutMapping("/service")
    public void PutService(@RequestBody Services service) {
        servicesService.put(service);
    }

}