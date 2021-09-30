package com.djoao.minhasFinancas.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.djoao.minhasFinancas.exception.RegraNegocioException;
import com.djoao.minhasFinancas.model.entity.Usuario;
import com.djoao.minhasFinancas.models.repository.UsuarioRepository;
import com.djoao.minhasFinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository repository;
	
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		
		return null;
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuario cadastrado com este e-mail");
		}
	}

}
