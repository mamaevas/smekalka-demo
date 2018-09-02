package com.mamaevas.smekalka.demo.repository;

import com.mamaevas.smekalka.demo.entity.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
    Optional<Transmission> findByName(String name);
}
