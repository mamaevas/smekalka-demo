package com.mamaevas.smekalka.demo.repository;

import com.mamaevas.smekalka.demo.entity.Track;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO track_car VALUES (:trackId, :carId)")
    int insertCarToTrack(@Param("trackId") @NonNull Long trackId, @Param("carId") @NonNull Long carId);
}
