package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.backend.repository.GraphRepository;
import com.crud.backend.model.Graph;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GraphController {
    @Autowired
    private GraphRepository graphRepository;

    @RequestMapping(value = "/graph", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Graph> GetData() {
        return graphRepository.findAll();
    }

    @RequestMapping(value = "/graph/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Graph GetMetric(@PathVariable String id) {
        return graphRepository.findById(id).orElse(null);
    }

    @PostMapping("/graph")
    public Graph PostModel(@RequestBody Graph model) {
        return graphRepository.save(model);
    }
}