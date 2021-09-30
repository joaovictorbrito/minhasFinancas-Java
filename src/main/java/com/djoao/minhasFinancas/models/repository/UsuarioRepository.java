package com.djoao.minhasFinancas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djoao.minhasFinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	boolean existsByEmail(String email);
}
