package com.booking.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.api.model.Seat;
import java.util.List;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    //ne ajuta sa gasim toate scaunele unui evenimnet
    List<Seat> findByEventId(Long eventId);
}
