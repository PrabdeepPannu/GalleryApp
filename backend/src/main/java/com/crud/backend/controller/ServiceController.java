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
import com.crud.backend.model.Service;
import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.repository.ServiceRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ServiceController {
    @Autowired
    private ServiceRepository sericeRepository;

    @GetMapping("/service")
    public List<Service> GetServices() {
        return sericeRepository.findAll();
    }

    @GetMapping("/service/{id}/model")
    public List<Model> GetModels(@PathVariable String id) {
        Service service = sericeRepository.findById(id).orElse(null);
        if (service != null) {
            return service.getModels();
        }
        return null;
    }

    @GetMapping("/service/{id}")
    public Service GetService(@PathVariable String id) {
        return sericeRepository.findById(id).orElse(null);
    }

    @PostMapping("/service")
    public Service PostService(@RequestBody Service service) {
        return sericeRepository.save(service);
    }

    @PutMapping("/service")
    public void PutService(@RequestBody Service service) {
        Service oldService = sericeRepository.findById(service.getId()).orElse(null);
        oldService.setName(service.getName());
        sericeRepository.save(oldService);
    }

}