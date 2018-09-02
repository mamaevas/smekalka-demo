package com.mamaevas.smekalka.demo.repository;

import com.mamaevas.smekalka.demo.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {
}
