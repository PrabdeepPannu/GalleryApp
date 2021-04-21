package com.crud.backend.repository;

import java.util.List;

import com.crud.backend.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends JpaRepository<Graph, String> {
    // list all the graphs related to Metric table
    @Query(value = "Select * from graph use index(idx_graph) where graph.metric_id = :metricId", nativeQuery = true)
    public List<Graph> getGraphByMetricId(@Param("metricId") String id);

}