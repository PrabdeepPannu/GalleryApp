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
import com.crud.backend.repository.MetricRepository;
import com.crud.backend.model.Graph;
import com.crud.backend.model.Metric;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MetricController {
    @Autowired
    private MetricRepository metricRepository;

    @RequestMapping(value = "/metric", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Metric> GetMetrics() {
        return metricRepository.findAll();
    }

    @RequestMapping(value = "/metric/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Metric GetMetric(@PathVariable String id) {
        return metricRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/metric/{id}/data", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Graph> GetData(@PathVariable String id) {
        Metric metric = metricRepository.findById(id).orElse(null);
        if (metric != null) {
            return metric.getGraphData();
        }
        return null;
    }

    @PostMapping("/metric")
    public Metric PostMetric(@RequestBody Metric metric) {
        return metricRepository.save(metric);
    }

    @PutMapping("/metric")
    public void PutMetric(@RequestBody Metric metric) {
        Metric oldMetrics = metricRepository.findById(metric.getId()).orElse(null);
        oldMetrics.setDifference(metric.getDifference());
        oldMetrics.setModel(metric.getModel());
        oldMetrics.setName(metric.getName());
        metricRepository.save(oldMetrics);
    }

}