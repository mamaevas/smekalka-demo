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
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Transmission(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Transmission(String name) {
        this.name = name;
    }
}
