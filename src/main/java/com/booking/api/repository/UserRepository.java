package com.booking.api.repository;

import com.booking.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring va genera automat query-ul SQL: SELECT * FROM users WHERE email = ?
    boolean existsByEmail(String email);
}