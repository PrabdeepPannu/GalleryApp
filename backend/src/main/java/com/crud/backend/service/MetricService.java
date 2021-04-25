package com.crud.backend.service;

import java.util.Comparator;
import java.util.List;

import com.crud.backend.interfaces.ServiceImpl;
import com.crud.backend.model.Graph;
import com.crud.backend.model.Metric;
import com.crud.backend.repository.GraphRepository;
import com.crud.backend.repository.MetricRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MetricService implements ServiceImpl<Metric> {

    private boolean isPositive = false;

    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private GraphRepository graphRepository;

    private double getMaxValue(List<Graph> graphData) {
        Graph graphMax = graphData.stream().max(Comparator.comparing(v -> v.getHit())).get();
        System.out.print(graphMax);
        return graphMax.getHit();
    }

    private double getInflation(List<Graph> graphData) {
        int size = graphData.size();
        double inflation = 0.0;
        if (size > 2) {
            double lastIndex = graphData.get(size - 1).getHit();
            double secondLastIndex = graphData.get(size - 2).getHit();

            if (lastIndex > secondLastIndex) {
                inflation = (secondLastIndex / lastIndex) * 100;
                this.isPositive = true;
            } else {
                inflation = ((secondLastIndex - lastIndex) / secondLastIndex) * 100;
            }
        }
        return Math.round(inflation);
    }

    private List<Double> getHitArray(List<Graph> graphData) {
        List<Double> hits = graphData.stream().map(v -> v.getHit()).collect(Collectors.toList());
        return hits;
    }

    @Override
    public List<Metric> getAll() {
        List<Metric> metrics = metricRepository.findAll();
        metrics.forEach(metric -> {
            List<Graph> graphData = graphRepository.getGraphByMetricId(metric.getId());
            metric.setMaxValue(this.getMaxValue(graphData));
            metric.setInflation(this.getInflation(graphData));
            metric.setGraphData(this.getHitArray(graphData));
            metric.setPositive(this.isPositive);
        });
        return metrics;
    }

    @Override
    public List<Metric> getRecommendedList() {
        List<Metric> metrics = metricRepository.getRecommendedMetrics();
        metrics.forEach(metric -> {
            List<Graph> graphData = graphRepository.getGraphByMetricId(metric.getId());
            metric.setMaxValue(this.getMaxValue(graphData));
            metric.setInflation(this.getInflation(graphData));
            metric.setGraphData(this.getHitArray(graphData));
            metric.setPositive(this.isPositive);
        });
        return metrics;
    }

    @Override
    public Metric getById(String id) {
        Metric metric = metricRepository.findById(id).orElse(null);
        List<Graph> graphData = graphRepository.getGraphByMetricId(id);
        metric.setMaxValue(this.getMaxValue(graphData));
        metric.setInflation(this.getInflation(graphData));
        metric.setGraphData(this.getHitArray(graphData));
        return metric;
    }

    @Override
    public void save(Metric metric) {
        metricRepository.save(metric);
    }

    @Override
    public void put(Metric metric) {
        Metric oldMetrics = metricRepository.findById(metric.getId()).orElse(null);
        oldMetrics.setDifference(metric.getDifference());
        oldMetrics.setModel(metric.getModel());
        oldMetrics.setName(metric.getName());
        metricRepository.save(oldMetrics);
    }

    @Override
    public List<Metric> getByParentId(String id) {
        return metricRepository.getMetricByModelId(id);
    }
}
