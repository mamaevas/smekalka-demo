package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Measure;
import com.mamaevas.smekalka.demo.entity.Unit;
import com.mamaevas.smekalka.demo.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MeasureService extends AbstractService<Measure, Long> {
    @Autowired
    private UnitService unitService;

    public MeasureService(JpaRepository<Measure, Long> repository) {
        super(repository);
    }

    private MeasureRepository repository() {
        return (MeasureRepository) repository;
    }

    @Transactional
    public Measure save(Unit unit, Double value) {
        return repository().save(
                Measure.builder()
                        .unit(unitService.getOrSave(unit))
                        .value(value)
                        .build()
        );
    }
}
