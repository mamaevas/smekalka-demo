package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Unit;
import com.mamaevas.smekalka.demo.repository.UnitRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnitService extends AbstractService<Unit, Long> {
    public UnitService(JpaRepository<Unit, Long> repository) {
        super(repository);
    }

    private UnitRepository repository() {
        return (UnitRepository) repository;
    }

    @Transactional
    public Unit getOrSave(Unit unit) {
        return repository().findByName(unit.getName())
                .orElseGet(() -> repository().save(
                        Unit.builder()
                                .name(unit.getName())
                                .build()));
    }
}
