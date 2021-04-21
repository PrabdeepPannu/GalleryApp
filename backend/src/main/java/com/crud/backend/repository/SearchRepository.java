
package com.crud.backend.repository;

import java.util.List;

import com.crud.backend.model.Metric;
import com.crud.backend.model.Model;
import com.crud.backend.model.Parent;
import com.crud.backend.model.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Parent, String> {
    @Query(value = "Select * from metric use index(idx_metric) where metric.name LIKE LOWER(CONCAT('%',:name, '%'))", nativeQuery = true)
    public List<Metric> getMetricByName(@Param("name") String name);

    @Query(value = "Select * from model use index(idx_model) where model.name LIKE LOWER(CONCAT('%',:name, '%'))", nativeQuery = true)
    public List<Model> getModelByName(@Param("name") String name);

    @Query(value = "Select * from service use index(idx_service) where service.name LIKE LOWER(CONCAT('%',:name, '%'))", nativeQuery = true)
    public List<Service> getServiceByName(@Param("name") String name);
}