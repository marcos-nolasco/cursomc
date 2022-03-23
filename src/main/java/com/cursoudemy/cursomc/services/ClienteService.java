package com.cursoudemy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.cursomc.domain.Cliente;
import com.cursoudemy.cursomc.repositories.ClienteRepository;
import com.cursoudemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente find(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
