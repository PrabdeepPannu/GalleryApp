package com.crud.backend.repository;

import java.util.List;

import com.crud.backend.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

    // list all the Models related to Service
    @Query(value = "Select * from model use index(idx_model) where model.service_id = :serviceId", nativeQuery = true)
    public List<Model> getModelByServiceId(@Param("serviceId") String id);
}