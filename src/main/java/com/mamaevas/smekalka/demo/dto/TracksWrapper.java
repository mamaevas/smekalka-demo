package com.mamaevas.smekalka.demo.dto;

import com.mamaevas.smekalka.demo.entity.Track;
import lombok.Data;

import java.util.List;

@Data
public class TracksWrapper {
    private List<Track> tracks;
}
