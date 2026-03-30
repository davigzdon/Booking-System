# 🎟️ Sistem de Rezervări API (Booking System)

Acest proiect este un API REST complet pentru gestionarea rezervărilor de bilete, construit cu Spring Boot și PostgreSQL.

## 🏗️ Arhitectura Bazei de Date (Entități și Relații)

În acest moment, sistemul se bazează pe 4 mulțimi principale de date (Entități):

1. **User (Utilizatorul)** - Persoana care face rezervarea.
2. **Event (Evenimentul)** - Entitatea centrală (ex: un film, un concert).
3. **Seat (Scaunul)** - Resursa fizică, limitată. Relație de apartenență (Many-to-One) cu un `Event`. Aici vom implementa mecanisme de *Locking* pentru a preveni coliziunile (Race Conditions).
4. **Reservation (Rezervarea)** - Entitatea de legătură (Many-to-One cu `User` și One-to-One cu `Seat`), care conține un *timestamp* pentru expirare.

## 🛠️ Tehnologii Folosite
* Java 21 & Spring Boot 3
* PostgreSQL & Spring Data JPA (Hibernate)
* Validare matematică a datelor (Jakarta Validation)