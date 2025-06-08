package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.RecursoDto;
import com.gestaoabrigos.model.Recurso;
import com.gestaoabrigos.repository.RecursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoServiceImpl implements RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoServiceImpl(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public List<RecursoDto> findAll() {
        return recursoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecursoDto findById(Long id) {
        return recursoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado: " + id));
    }

    @Override
    public RecursoDto create(RecursoDto dto) {
        Recurso entity = toEntity(dto);
        Recurso saved = recursoRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public RecursoDto update(Long id, RecursoDto dto) {
        Recurso existing = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado: " + id));
        existing.setNome(dto.getNome());
        existing.setCategoria(dto.getCategoria());
        existing.setNivelCritico(dto.getNivelCritico());
        existing.setUnidadeMedida(dto.getUnidadeMedida());
        Recurso updated = recursoRepository.save(existing);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        recursoRepository.deleteById(id);
    }

    private RecursoDto toDto(Recurso entity) {
        RecursoDto dto = new RecursoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCategoria(entity.getCategoria());
        dto.setNivelCritico(entity.getNivelCritico());
        dto.setUnidadeMedida(entity.getUnidadeMedida());
        return dto;
    }

    private Recurso toEntity(RecursoDto dto) {
        Recurso entity = new Recurso();
        entity.setNome(dto.getNome());
        entity.setCategoria(dto.getCategoria());
        entity.setNivelCritico(dto.getNivelCritico());
        entity.setUnidadeMedida(dto.getUnidadeMedida());
        return entity;
    }
}
