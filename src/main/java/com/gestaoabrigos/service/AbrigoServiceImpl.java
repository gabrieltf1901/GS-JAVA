// AbrigoServiceImpl.java
package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.AbrigoDto;
import com.gestaoabrigos.model.Abrigo;
import com.gestaoabrigos.repository.AbrigoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbrigoServiceImpl implements AbrigoService {

    private final AbrigoRepository abrigoRepository;

    public AbrigoServiceImpl(AbrigoRepository abrigoRepository) {
        this.abrigoRepository = abrigoRepository;
    }

    @Override
    public List<AbrigoDto> findAll() {
        return abrigoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AbrigoDto findById(Long id) {
        return abrigoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado: " + id));
    }

    @Override
    public AbrigoDto create(AbrigoDto dto) {
        Abrigo entity = toEntity(dto);
        Abrigo saved = abrigoRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public AbrigoDto update(Long id, AbrigoDto dto) {
        Abrigo existing = abrigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado: " + id));
        existing.setNome(dto.getNome());
        existing.setEndereco(dto.getEndereco());
        existing.setLatitude(dto.getLatitude());
        existing.setLongitude(dto.getLongitude());
        existing.setCapacidadeTotal(dto.getCapacidadeTotal());
        existing.setStatus(dto.getStatus());
        Abrigo updated = abrigoRepository.save(existing);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        abrigoRepository.deleteById(id);
    }

    // Métodos auxiliares de conversão
    private AbrigoDto toDto(Abrigo entity) {
        AbrigoDto dto = new AbrigoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEndereco(entity.getEndereco());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setCapacidadeTotal(entity.getCapacidadeTotal());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    private Abrigo toEntity(AbrigoDto dto) {
        Abrigo entity = new Abrigo();
        entity.setNome(dto.getNome());
        entity.setEndereco(dto.getEndereco());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setCapacidadeTotal(dto.getCapacidadeTotal());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
