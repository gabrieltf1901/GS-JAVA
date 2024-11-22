package com.sustainable.energy.repository;

import com.sustainable.energy.model.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {
}
