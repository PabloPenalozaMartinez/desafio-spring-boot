package com.desafio.previred.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.previred.entity.Usuario;
import com.desafio.previred.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
    private UsuarioRepository usuarioRepository;

	@Override
	public boolean validarUsuarioPorNombre(String nombre) {
		 Iterable<Usuario> lista = usuarioRepository.findAll();
		 List<Usuario> result = StreamSupport.stream(lista.spliterator(), false)
				 .filter(u -> u.getNombre().equals(nombre))
			     .collect(Collectors.toList());
		 return result.size() == 1 ? true : false;
	}

}
