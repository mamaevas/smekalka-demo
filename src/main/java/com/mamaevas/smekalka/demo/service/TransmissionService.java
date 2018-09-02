package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Transmission;
import com.mamaevas.smekalka.demo.repository.TransmissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransmissionService extends AbstractService<Transmission, Integer> {
    public TransmissionService(JpaRepository<Transmission, Integer> repository) {
        super(repository);
    }

    private TransmissionRepository repository() {
        return (TransmissionRepository) repository;
    }

    @Transactional
    public Transmission getOrSave(Transmission transmission) {
        return repository().findByName(transmission.getName())
                .orElseGet(() -> repository().save(
                        Transmission.builder()
                                .name(transmission.getName())
                                .build()));
    }
}
