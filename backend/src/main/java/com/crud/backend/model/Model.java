package com.crud.backend.model;

import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "model", indexes = @Index(name = "idx_model_name", columnList = "name"))
public class Model {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "name")
    private String Name;

    @Column(name = "type")
    private String Type;

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
