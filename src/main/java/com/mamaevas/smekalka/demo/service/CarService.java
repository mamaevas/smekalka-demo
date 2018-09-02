package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Car;
import com.mamaevas.smekalka.demo.repository.CarRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends AbstractService<Car, Long> {
    public CarService(JpaRepository<Car, Long> repository) {
        super(repository);
    }

    private CarRepository repository() {
        return (CarRepository) repository;
    }
}
