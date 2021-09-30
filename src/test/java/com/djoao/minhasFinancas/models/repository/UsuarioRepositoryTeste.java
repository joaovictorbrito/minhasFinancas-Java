package com.djoao.minhasFinancas.models.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.djoao.minhasFinancas.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTeste {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void verificaAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		//ação/execução
		boolean result = repository.existsByEmail("usuario@email.com");	
		
		//verificação
		Assertions.assertThat(result).isTrue();
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		//cenario
		repository.deleteAll();
		
		//ação/execução
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		assertDoesNotThrow(() -> Assertions.assertThat(result).isFalse());
		
	}
}
