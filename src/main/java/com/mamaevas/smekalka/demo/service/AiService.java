package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Ai;
import com.mamaevas.smekalka.demo.repository.AiRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AiService extends AbstractService<Ai, Integer> {
    public AiService(JpaRepository<Ai, Integer> repository) {
        super(repository);
    }

    private AiRepository repository() {
        return (AiRepository) repository;
    }

    @Transactional
    public Ai getOrSave(Ai ai) {
        return repository().findByCode(ai.getCode())
                .orElseGet(() -> repository().save(
                        Ai.builder()
                                .code(ai.getCode())
                                .build()
                ));
    }
}
