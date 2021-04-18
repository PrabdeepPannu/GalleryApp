package com.crud.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.crud.backend.repository.SearchRepository;
import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.model.Parent;
import com.crud.backend.model.Service;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearchController {
    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/search/{name}")
    public List<Parent> GetSearchResults(@PathVariable String name) {
        List<Parent> listSearch = new ArrayList<Parent>();
        listSearch.addAll(searchRepository.getServiceByName(name));
        listSearch.addAll(searchRepository.getModelByName(name));
        listSearch.addAll(searchRepository.getMetricByName(name));
        return listSearch;
    }

    @GetMapping("/search/service/{name}")
    public List<Service> GetServices(@PathVariable String name) {
        return searchRepository.getServiceByName(name);
    }

    @GetMapping("/search/model/{name}")
    public List<Model> GetModels(@PathVariable String name) {
        return searchRepository.getModelByName(name);
    }

    @GetMapping("/search/metric/{name}")
    public List<Metric> GetMetrics(@PathVariable String name) {
        return searchRepository.getMetricByName(name);
    }

}