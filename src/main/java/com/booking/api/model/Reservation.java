package com.booking.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reservations")

public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //relatia cu userul care a facut rezervarea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //realtia cu scaunul rezervat
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false, unique = true)
    private Seat seat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status = ReservationStatus.PENDING;
    
    //axa timpului (momentul rezervarii)
    @Column(nullable = false, updatable = false)
    private LocalDateTime reservedAt = LocalDateTime.now();

    //momentul in care rezervarea expira daca nu este confirmata (ex: 15 minute de la rezervare)
    @Column(nullable = false)
    private LocalDateTime expiresAt;

}
