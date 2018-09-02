package com.mamaevas.smekalka.demo.repository;

import com.mamaevas.smekalka.demo.entity.Ai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AiRepository extends JpaRepository<Ai, Integer> {
    Optional<Ai> findByCode(String code);
}
