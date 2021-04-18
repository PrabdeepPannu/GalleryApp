package com.crud.backend.model;

import javax.persistence.Entity;

import javax.persistence.Table;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Index;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "model", indexes = @Index(name = "idx_model_name", columnList = "id, name, type"))
public class Model extends Parent {

    @Builder
    public Model(String id, String name, String type, String userName, String password, String api, String query) {
        super(id, name, type);
        this.userName = userName;
        this.password = password;
        this.api = api;
        this.query = query;
    }

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "api")
    private String api;

    @Column(name = "query")
    private String query;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Service service;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Metric> metrics = new ArrayList<>();
}
