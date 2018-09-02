package com.mamaevas.smekalka.demo.api;

import com.mamaevas.smekalka.demo.dto.TracksWrapper;
import com.mamaevas.smekalka.demo.entity.Track;
import com.mamaevas.smekalka.demo.service.CustomService;
import com.mamaevas.smekalka.demo.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api")
public class Api {
    private final CustomService customService;
    private final TrackService trackService;

    @Autowired
    public Api(CustomService customService,
               TrackService trackService) {
        this.customService = customService;
        this.trackService = trackService;
    }

    @GetMapping(value = "/health", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping(value = "/tracks", produces = "application/json; charset=UTF-8")
    public Iterable<Track> findAllTracks() {
        return trackService.findAll();
    }

    @PostMapping(value = "/save", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> saveToDatabase(@RequestBody TracksWrapper tracks) {
        try {
            customService.saveToDatabase(tracks.getTracks());
        } catch (Exception e) {
            log.warn(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
