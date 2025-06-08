// AbrigoRepository.java
package com.gestaoabrigos.repository;

import com.gestaoabrigos.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para operações CRUD sobre Abrigo.
 */
@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    // Aqui você pode definir métodos de consulta personalizados, se necessário
}