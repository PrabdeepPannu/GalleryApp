package com.crud.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Index;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metric", indexes = @Index(name = "idx_metric", columnList = "id, name, type"))
public class Metric extends Parent {

    @Builder
    public Metric(String id, String name, String type, int difference) {
        super(id, name, type);
        this.difference = difference;
    }

    public Metric(String id, String name, String type, int difference) {
        super(id, name, type);
        this.difference = difference;
    }

    @Column(name = "difference")
    private int difference;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = true)
    private Model model;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = true)
    private Services service;

    @Transient
    private double inflation;

    @Transient
    private double maxValue;

    @Transient
    private List<Double> graphData;

    @Transient
    private boolean positive;
}
