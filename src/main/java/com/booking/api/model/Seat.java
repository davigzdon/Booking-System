package com.booking.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Numărul sau codul scaunului (ex: "Rândul A, Scaunul 12" -> "A12")
    @Column(nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status = SeatStatus.AVAILABLE;

    // RELAȚIA MATEMATICĂ: Un eveniment are mai multe scaune (N:1 din perspectiva scaunului)
    // În baza de date se va crea o coloană numită "event_id" care este Foreign Key (Cheie Străină)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // MECANISMUL DE LOCKING CONCURENȚIAL:
    // De fiecare dată când un rând este updatat (ex: status trece din AVAILABLE in RESERVED),
    // Spring Boot incrementează automat această valoare (0 -> 1 -> 2).
    // Dacă doi utilizatori citesc versiunea 0 și încearcă să o updateze simultan, 
    // primul câștigă (versiunea devine 1). Al doilea va pica la validare, protejând datele.
    @Version
    private Long version;
}