package com.djoao.minhasFinancas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djoao.minhasFinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
