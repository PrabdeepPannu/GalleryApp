package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.crud.backend.repository.ModelRepository;
import com.crud.backend.model.Model;
import com.crud.backend.model.Metric;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ModelController {
    @Autowired
    private ModelRepository modelRepository;

    @RequestMapping(value = "/model", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Model> GetModels() {
        return modelRepository.findAll();
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Model GetModel(@PathVariable String id) {
        return modelRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/model/{id}/metric", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Metric> GetMetrics(@PathVariable String id) {
        Model model = modelRepository.findById(id).orElse(null);
        if (model != null) {
            return model.getMetrics();
        }
        return null;
    }

    @PostMapping("/model")
    public Model PostModel(@RequestBody Model model) {
        return modelRepository.save(model);
    }

    @PutMapping("/model")
    public void PutModel(@RequestBody Model model) {
        Model oldModel = modelRepository.findById(model.getId()).orElse(null);
        oldModel.setApi(oldModel.getApi());
        oldModel.setName(oldModel.getName());
        oldModel.setUserName(oldModel.getUserName());
        oldModel.setPassword(oldModel.getPassword());
        oldModel.setQuery(oldModel.getQuery());
        modelRepository.save(oldModel);
    }

}