package com.sustainable.energy.service;

import com.sustainable.energy.exception.ResourceNotFoundException;
import com.sustainable.energy.model.Configuracao;
import com.sustainable.energy.repository.ConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    public List<Configuracao> findAll() {
        return configuracaoRepository.findAll();
    }

    public Configuracao findById(Long id) {
        return configuracaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Configuração não encontrado!"));
    }

    public Configuracao save(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }

    public void delete(Long id) {
        configuracaoRepository.deleteById(id);
    }
}
