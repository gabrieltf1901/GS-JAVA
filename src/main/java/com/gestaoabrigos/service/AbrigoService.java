package com.gestaoabrigos.service;

import com.gestaoabrigos.dto.AbrigoDto;
import java.util.List;

public interface AbrigoService {
    List<AbrigoDto> findAll();
    AbrigoDto findById(Long id);
    AbrigoDto create(AbrigoDto dto);
    AbrigoDto update(Long id, AbrigoDto dto);
    void delete(Long id);
}