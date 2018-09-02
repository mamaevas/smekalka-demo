package com.mamaevas.smekalka.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomRepository {
    private final TrackRepository trackRepository;
    private final CarRepository carRepository;

    @Autowired
    public CustomRepository(TrackRepository trackRepository, CarRepository carRepository) {
        this.trackRepository = trackRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public void cleanTracksAndCars() {
        trackRepository.deleteAll();
        carRepository.deleteAll();
    }
}
