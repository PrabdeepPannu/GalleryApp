package com.crud.backend.service;

import java.util.List;

import com.crud.backend.interfaces.ServiceImpl;
import com.crud.backend.model.Services;
import com.crud.backend.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService implements ServiceImpl<Services> {

    @Autowired
    private ServiceRepository sericeRepository;

    @Override
    public List<Services> getAll() {
        return sericeRepository.findAll();
    }

    @Override
    public List<Services> getRecommendedList() {
        return sericeRepository.getRecommendedServices();
    }

    @Override
    public Services getById(String id) {
        return sericeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Services service) {
        sericeRepository.save(service);

    }

    @Override
    public void put(Services service) {
        Services oldService = sericeRepository.findById(service.getId()).orElse(null);
        oldService.setName(service.getName());
        sericeRepository.save(oldService);

    }

    @Override
    public List<Services> getByParentId(String id) {
        return null;
    }
}
