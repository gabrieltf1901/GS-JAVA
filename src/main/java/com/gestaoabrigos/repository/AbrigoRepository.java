package com.gestaoabrigos.repository;

import com.gestaoabrigos.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
}