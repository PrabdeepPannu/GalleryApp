package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.crud.backend.service.GraphService;
import com.crud.backend.model.Graph;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GraphController {

    @Autowired
    private GraphService graphService;

    @GetMapping("/graph")
    public List<Graph> GetData() {
        return graphService.getAll();
    }

    @GetMapping("/graph/{id}")
    public Graph GetDataById(@PathVariable String id) {
        Graph graph = graphService.getById(id);
        if (graph == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Graph Not Found");
        }
        return graph;
    }

    @PostMapping("/graph")
    public void PostModel(@RequestBody Graph graph) {
        graphService.save(graph);
    }

    @GetMapping("/metric/{id}/data")
    public List<Graph> GetDataByMetricId(@PathVariable String id) {
        return graphService.getByParentId(id);
    }
}