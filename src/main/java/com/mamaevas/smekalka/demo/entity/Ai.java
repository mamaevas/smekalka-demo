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
public class Ai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;

    public Ai(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Ai(String code) {
        this.code = code;
    }
}
