package com.sustainable.energy.service;

import com.sustainable.energy.exception.ResourceNotFoundException;
import com.sustainable.energy.model.Recomendacao;
import com.sustainable.energy.repository.RecomendacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoService {

    @Autowired
    private RecomendacaoRepository recomendacaoRepository;

    public List<Recomendacao> findAll() {
        return recomendacaoRepository.findAll();
    }

    public Recomendacao findById(Long id) {
        return recomendacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recomendação não encontrado!"));
    }

    public Recomendacao save(Recomendacao recomendacao) {
        return recomendacaoRepository.save(recomendacao);
    }

    public void delete(Long id) {
        recomendacaoRepository.deleteById(id);
    }
}
