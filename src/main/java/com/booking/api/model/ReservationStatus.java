package com.booking.api.model;

public enum ReservationStatus {
  PENDING,   // Așteaptă plata
  CONFIRMED, // Plata a reușit
  CANCELLED, // Anulată manual de utilizator
  EXPIRED    // A expirat timpul alocat (TTL - Time To Live)
    
}
