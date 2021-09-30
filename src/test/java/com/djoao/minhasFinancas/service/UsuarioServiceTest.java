package com.djoao.minhasFinancas.service;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.djoao.minhasFinancas.exception.RegraNegocioException;
import com.djoao.minhasFinancas.model.entity.Usuario;
import com.djoao.minhasFinancas.models.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	

	@Test
	public void deveValidarEmail() {
		Assertions.assertDoesNotThrow(()-> {
			//cenario
			repository.deleteAll();
			
			//ação
			service.validarEmail("email@email.com");	
		});
		
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuantoExistirEmailCdastrado() {
		Assertions.assertThrows(RegraNegocioException.class, () -> {
			//cenario
			Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
			repository.save(usuario);
			//acao 
			service.validarEmail("email@email.com");			
		});
	}
	
}
