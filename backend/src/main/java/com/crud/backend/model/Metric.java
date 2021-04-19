package com.crud.backend.model;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Index;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metric", indexes = @Index(name = "idx_metric_name", columnList = "id, name, type"))
public class Metric extends Parent {

    @Builder
    public Metric(String id, String name, String type, int difference) {
        super(id, name, type);
        this.difference = difference;
    }

    @Column(name = "difference")
    private int difference;

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private List<Graph> graphData = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private Model model;

}
