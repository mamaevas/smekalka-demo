package com.mamaevas.smekalka.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
public class Track {
    @Id
    private Long id;
    private String name;
    private String description;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "length_id")
    private Measure length;
    @ManyToMany(mappedBy = "tracks", fetch = FetchType.EAGER)
    private List<Car> cars;
}
