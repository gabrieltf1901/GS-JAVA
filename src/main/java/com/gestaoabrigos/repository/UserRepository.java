package com.gestaoabrigos.repository;

import com.gestaoabrigos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Busca case-insensitive
    Optional<User> findByUsernameIgnoreCase(String username);

    // Verifica existência case-insensitive
    boolean existsByUsernameIgnoreCase(String username);

    // Alternativa com @Query, se preferir garantir lower()
    @Query("SELECT u FROM User u WHERE lower(u.username) = lower(:username)")
    Optional<User> findByUsernameLower(@Param("username") String username);
}
