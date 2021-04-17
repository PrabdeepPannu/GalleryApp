package com.crud.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service", indexes = @Index(name = "idx_service_name", columnList = "name"))
public class Service {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String Name;

    @Column(name = "type")
    private String Type;

    @Column(name = "pic_byte", length = 1000)
    private byte[] picByte;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service", cascade = CascadeType.ALL)
    private List<Model> models = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service", cascade = CascadeType.ALL)
    private List<Metric> metrics = new ArrayList<>();

}
