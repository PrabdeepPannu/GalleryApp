package com.crud.backend.repository;

import java.util.List;

import com.crud.backend.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services, String> {

    // list all the Recommented services related to Service table
    @Query(value = "Select * from service limit 12", nativeQuery = true)
    public List<Services> getRecommendedServices();

}