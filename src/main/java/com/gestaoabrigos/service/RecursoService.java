package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.RecursoDto;
import java.util.List;

public interface RecursoService {
    List<RecursoDto> findAll();
    RecursoDto findById(Long id);
    RecursoDto create(RecursoDto dto);
    RecursoDto update(Long id, RecursoDto dto);
    void delete(Long id);
}