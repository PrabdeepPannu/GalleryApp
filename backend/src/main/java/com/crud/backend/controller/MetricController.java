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
import com.crud.backend.service.MetricService;
import com.crud.backend.model.Metric;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MetricController {

    @Autowired
    private MetricService metricService;

    @GetMapping("/metric")
    public List<Metric> GetMetrics() {
        return metricService.getAll();
    }

    @GetMapping("/metric/recommended")
    public List<Metric> GetRecommendeMetrics() {
        return metricService.getRecommendedList();
    }

    @GetMapping("/metric/{id}")
    public Metric GetMetric(@PathVariable String id) {
        Metric metric = metricService.getById(id);
        if (metric == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Metric Not Found");
        }
        return metric;
    }

    // @GetMapping("/service/{id}/metrics")
    // public List<Metric> GetMetricByServiceId(@PathVariable String id) {
    // return metricService.getMetricByServiceId(id);
    // }

    @GetMapping("/model/{id}/metrics")
    public List<Metric> GetMetrics(@PathVariable String id) {
        return metricService.getByParentId(id);
    }

    @PostMapping("/metric")
    public void PostMetric(@RequestBody Metric metric) {
        metricService.save(metric);
    }

    @PutMapping("/metric")
    public void PutMetric(@RequestBody Metric metric) {
        metricService.put(metric);
    }

}