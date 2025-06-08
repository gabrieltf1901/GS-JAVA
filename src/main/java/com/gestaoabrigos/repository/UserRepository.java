package com.gestaoabrigos.repository;

import com.gestaoabrigos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

    boolean existsByUsernameIgnoreCase(String username);

    @Query("SELECT u FROM User u WHERE lower(u.username) = lower(:username)")
    Optional<User> findByUsernameLower(@Param("username") String username);
}
