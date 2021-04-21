package com.crud.backend.repository;

import java.util.List;

import com.crud.backend.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric, String> {

    // list all the Metrics related to Service table
    @Query(value = "Select * from metric use index(idx_metric) where metric.service_id = :serviceId", nativeQuery = true)
    public List<Metric> getMetricByServiceId(@Param("serviceId") String id);

    // list all the Metrics related to Model table
    @Query(value = "Select * from metric use index(idx_metric) where metric.model_id = :modelId", nativeQuery = true)
    public List<Metric> getMetricByModelId(@Param("modelId") String id);

}