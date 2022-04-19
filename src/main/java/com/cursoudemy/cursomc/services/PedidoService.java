package com.cursoudemy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.cursomc.domain.Pedido;
import com.cursoudemy.cursomc.repositories.PedidoRepository;
import com.cursoudemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id){
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Pedido find(Integer id){
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
