package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Car;
import com.mamaevas.smekalka.demo.entity.Track;
import com.mamaevas.smekalka.demo.repository.TrackRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrackService extends AbstractService<Track, Long> {
    public TrackService(JpaRepository<Track, Long> repository) {
        super(repository);
    }

    private TrackRepository repository() {
        return (TrackRepository) repository;
    }

    @Transactional
    public int insertCarToTrack(Track t, Car c) {
        return repository().insertCarToTrack(t.getId(), c.getId());
    }

    public Iterable<Track> findAll() {
        return repository().findAll();
    }
}
