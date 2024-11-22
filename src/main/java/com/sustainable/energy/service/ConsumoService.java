package com.sustainable.energy.service;

import com.sustainable.energy.exception.ResourceNotFoundException;
import com.sustainable.energy.model.Consumo;
import com.sustainable.energy.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    public List<Consumo> findAll() {
        return consumoRepository.findAll();
    }

    public Consumo findById(Long id) {
        return consumoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consumo não encontrado!"));
    }

    public Consumo save(Consumo consumo) {
        return consumoRepository.save(consumo);
    }

    public void delete(Long id) {
        consumoRepository.deleteById(id);
    }
}
