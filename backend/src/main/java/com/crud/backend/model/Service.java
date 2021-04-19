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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service", indexes = @Index(name = "idx_service_name", columnList = "id, name, type"))
public class Service extends Parent {

    @Builder
    public Service(String id, String name, String type, String iconUrl) {
        super(id, name, type);
        this.iconUrl = iconUrl;
    }

    @Column(name = "icon_url")
    private String iconUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service", cascade = CascadeType.ALL)
    private List<Model> models = new ArrayList<>();
}
