package com.booking.api.model;

public enum SeatStatus {
    AVAILABLE,  // Liber pentru a fi selectat
    RESERVED,   // Blocat temporar (ex: 10 minute cât utilizatorul introduce cardul)
    SOLD        // Vândut definitiv
}