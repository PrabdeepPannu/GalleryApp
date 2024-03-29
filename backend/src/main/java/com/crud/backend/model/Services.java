package com.crud.backend.model;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service", indexes = @Index(name = "idx_service", columnList = "id, name, type"))
public class Services extends Parent {

    @Builder
    public Services(String id, String name, String type, String iconUrl) {
        super(id, name, type);
        this.iconUrl = iconUrl;
    }

    @Column(name = "icon_url")
    private String iconUrl;
}
