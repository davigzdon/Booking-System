package com.booking.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.api.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
}
