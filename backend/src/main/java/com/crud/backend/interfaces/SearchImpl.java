package com.crud.backend.interfaces;

import java.util.List;

import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.model.Parent;
import com.crud.backend.model.Services;

public interface SearchImpl {
    public abstract List<Parent> getSearchResults(String name);

    public abstract List<Services> getServices(String name);

    public abstract List<Model> getModels(String name);

    public abstract List<Metric> getMetrics(String name);
}
