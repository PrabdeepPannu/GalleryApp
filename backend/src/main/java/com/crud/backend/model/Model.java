package com.crud.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Table(name = "model", indexes = @Index(name = "idx_model", columnList = "id, name, type, service_id"))
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

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = true)
    private Service service;
}
