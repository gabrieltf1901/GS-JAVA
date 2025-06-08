// RecursoService.java
package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.RecursoDto;
import java.util.List;

/**
 * Interface de serviço para operações de Recurso.
 */
public interface RecursoService {
    List<RecursoDto> findAll();
    RecursoDto findById(Long id);
    RecursoDto create(RecursoDto dto);
    RecursoDto update(Long id, RecursoDto dto);
    void delete(Long id);
}