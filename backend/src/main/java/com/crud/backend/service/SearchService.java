package com.crud.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.crud.backend.interfaces.SearchImpl;
import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.model.Parent;
import com.crud.backend.model.Services;
import com.crud.backend.repository.SearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService implements SearchImpl {
    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<Parent> getSearchResults(String name) {
        List<Parent> listSearch = new ArrayList<Parent>();
        listSearch.addAll(searchRepository.getServiceByName(name));
        listSearch.addAll(searchRepository.getModelByName(name));
        listSearch.addAll(searchRepository.getMetricByName(name));
        return listSearch;
    }

    @Override
    public List<Services> getServices(String name) {
        return searchRepository.getServiceByName(name);
    }

    @Override
    public List<Model> getModels(String name) {
        return searchRepository.getModelByName(name);
    }

    @Override
    public List<Metric> getMetrics(String name) {
        return searchRepository.getMetricByName(name);
    }

}
