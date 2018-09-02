package com.mamaevas.smekalka.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Unit(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Unit(String name) {
        this.name = name;
    }
}
