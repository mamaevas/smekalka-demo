package com.mamaevas.smekalka.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "unit_id")
    private Unit unit;
    private Double value;
}
