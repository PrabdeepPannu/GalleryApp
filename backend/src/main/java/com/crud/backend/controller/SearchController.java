package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.crud.backend.service.SearchService;
import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.model.Parent;
import com.crud.backend.model.Services;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/{name}")
    public List<Parent> GetSearchResults(@PathVariable String name) {
        return searchService.getSearchResults(name);
    }

    @GetMapping("/search/service/{name}")
    public List<Services> GetServices(@PathVariable String name) {
        return searchService.getServices(name);
    }

    @GetMapping("/search/model/{name}")
    public List<Model> GetModels(@PathVariable String name) {
        return searchService.getModels(name);
    }

    @GetMapping("/search/metric/{name}")
    public List<Metric> GetMetrics(@PathVariable String name) {
        return searchService.getMetrics(name);
    }

}