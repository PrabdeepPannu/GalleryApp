package com.crud.backend.service;

import java.util.List;

import com.crud.backend.interfaces.ServiceImpl;
import com.crud.backend.model.Graph;
import com.crud.backend.repository.GraphRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphService implements ServiceImpl<Graph> {

    @Autowired
    private GraphRepository graphRepository;

    @Override
    public List<Graph> getAll() {
        return graphRepository.findAll();
    }

    @Override
    public List<Graph> getRecommendedList() {
        return null;
    }

    @Override
    public Graph getById(String id) {
        return graphRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Graph graph) {
        graphRepository.save(graph);
    }

    @Override
    public void put(Graph parent) {
    }

    @Override
    public List<Graph> getByParentId(String id) {
        return graphRepository.getGraphByMetricId(id);
    }

}
