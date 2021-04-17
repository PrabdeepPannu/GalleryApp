package com.crud.backend.model;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metric", indexes = @Index(name = "idx_metric_name", columnList = "name"))
public class Metric {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String Name;

    @Column(name = "type")
    private String Type;

    @Column(name = "data")
    private String Data;

    @Column(name = "difference")
    private int Difference;

    @ManyToOne
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Service service;

    
}
