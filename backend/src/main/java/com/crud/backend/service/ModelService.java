package com.crud.backend.service;

import java.util.List;

import com.crud.backend.interfaces.ServiceImpl;
import com.crud.backend.model.Model;
import com.crud.backend.repository.ModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService implements ServiceImpl<Model> {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public List<Model> getRecommendedList() {
        return modelRepository.getRecommendedModels();
    }

    @Override
    public Model getById(String id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Model model) {
        modelRepository.save(model);

    }

    @Override
    public void put(Model model) {
        Model oldModel = modelRepository.findById(model.getId()).orElse(null);
        oldModel.setApi(oldModel.getApi());
        oldModel.setName(oldModel.getName());
        oldModel.setUserName(oldModel.getUserName());
        oldModel.setPassword(oldModel.getPassword());
        oldModel.setQuery(oldModel.getQuery());
        modelRepository.save(oldModel);

    }

    @Override
    public List<Model> getByParentId(String id) {
        return modelRepository.getModelByServiceId(id);
    }

}
