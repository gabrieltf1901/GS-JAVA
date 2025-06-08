package com.gestaoabrigos.repository;

import com.gestaoabrigos.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}