package com.sustainable.energy.service;

import com.sustainable.energy.exception.ResourceNotFoundException;
import com.sustainable.energy.model.Dispositivo;
import com.sustainable.energy.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<Dispositivo> findAll() {
        return dispositivoRepository.findAll();
    }

    public Dispositivo findById(Long id) {
        return dispositivoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado!"));
    }

    public Dispositivo save(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public void delete(Long id) {
        dispositivoRepository.deleteById(id);
    }
}
