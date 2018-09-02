package com.mamaevas.smekalka.demo.service;

import com.mamaevas.smekalka.demo.entity.Track;
import com.mamaevas.smekalka.demo.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomService {
    private final CustomRepository customRepository;
    private final AiService aiService;
    private final CarService carService;
    private final MeasureService measureService;
    private final TrackService trackService;
    private final TransmissionService transmissionService;
    private final UnitService unitService;

    @Autowired
    public CustomService(CustomRepository customRepository, AiService aiService, CarService carService, MeasureService measureService, TrackService trackService, TransmissionService transmissionService, UnitService unitService) {
        this.customRepository = customRepository;
        this.aiService = aiService;
        this.carService = carService;
        this.measureService = measureService;
        this.trackService = trackService;
        this.transmissionService = transmissionService;
        this.unitService = unitService;
    }

    @Transactional
    public void cleanTracksAndCars() {
        customRepository.cleanTracksAndCars();
    }

    @Transactional
    public void saveToDatabase(Iterable<Track> tracks) {
        cleanTracksAndCars();
        tracks.forEach(t -> {
                    t.getCars().forEach(c -> {
                        c.setTransmission(transmissionService.getOrSave(c.getTransmission()));
                        c.setAi(aiService.getOrSave(c.getAi()));
                        c.setMaxSpeed(measureService.save(c.getMaxSpeed().getUnit(), c.getMaxSpeed().getValue()));
                        carService.save(c);
                    });
                    t.setLength(measureService.save(t.getLength().getUnit(), t.getLength().getValue()));
                    trackService.save(t);
                    t.getCars().forEach(c -> trackService.insertCarToTrack(t, c));
                }
        );
    }
}
