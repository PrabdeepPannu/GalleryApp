package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.crud.backend.service.ModelService;
import com.crud.backend.model.Model;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/model")
    public List<Model> GetModels() {
        return modelService.getAll();
    }

    @GetMapping("/model/recommended")
    public List<Model> GetRecommendeModels() {
        return modelService.getRecommendedList();
    }

    @GetMapping("/model/{id}")
    public Model GetModel(@PathVariable String id) {
        Model model = modelService.getById(id);
        if (model == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Model Not Found");
        }
        return model;
    }

    @GetMapping("/service/{id}/models")
    public List<Model> GetModelsByServiceId(@PathVariable String id) {
        return modelService.getByParentId(id);
    }

    @PostMapping("/model")
    public void PostModel(@RequestBody Model model) {
        modelService.save(model);
    }

    @PutMapping("/model")
    public void PutModel(@RequestBody Model model) {
        modelService.put(model);
    }

}