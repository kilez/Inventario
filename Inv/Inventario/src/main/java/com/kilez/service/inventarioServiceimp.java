package com.kilez.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.kilez.Repository.inventarioRepository;
import com.kilez.entity.Inventario;

@Service
public class inventarioServiceimp implements inventarioService {

	@Autowired
	private inventarioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable <Inventario> findAll() {
		
		return repository.findAll();
	}
	
	@Override
	@Transactional
	public Inventario save(Inventario inventario) {
		
		return repository.save(inventario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Inventario> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void delateById(Long id) {
		repository.deleteById(id);
	}
	

	
	
	
}
