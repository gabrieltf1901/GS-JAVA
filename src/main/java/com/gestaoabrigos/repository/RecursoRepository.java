// RecursoRepository.java
package com.gestaoabrigos.repository;

import com.gestaoabrigos.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para operações CRUD sobre Recurso.
 */
@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    // Métodos de consulta adicionais podem ser declarados aqui
}