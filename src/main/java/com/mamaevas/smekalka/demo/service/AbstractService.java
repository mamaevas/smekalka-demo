package com.mamaevas.smekalka.demo.service;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional(readOnly = true)
public abstract class AbstractService<E, ID extends Serializable> {
    protected JpaRepository<E, ID> repository;

    public AbstractService(JpaRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Transactional
    public E save(@NonNull E entity) {
        return repository.save(entity);
    }

    @Transactional
    public Iterable<E> save(@NonNull Iterable<E> entities) {
        return repository.saveAll(entities);
    }
}
