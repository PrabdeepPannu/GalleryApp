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
import com.crud.backend.repository.MetricRepository;
import com.crud.backend.model.Metric;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MetricController {
    @Autowired
    private MetricRepository metricRepository;

    @GetMapping("/metric")
    public List<Metric> GetMetrics() {
        return metricRepository.findAll();
    }

    @GetMapping("/metric/{id}")
    public Metric GetMetric(@PathVariable String id) {
        return metricRepository.findById(id).orElse(null);
    }

    @GetMapping("/service/{id}/metrics")
    public List<Metric> GetMetricByServiceId(@PathVariable String id) {
        return metricRepository.getMetricByServiceId(id);
    }

    @GetMapping("/model/{id}/metrics")
    public List<Metric> GetMetrics(@PathVariable String id) {
        return metricRepository.getMetricByModelId(id);
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