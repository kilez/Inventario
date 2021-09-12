package com.kilez.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kilez.entity.Inventario;


public interface inventarioService {

	public Iterable <Inventario> findAll();
	
	public Inventario save(Inventario inventario);
	
	public Optional <Inventario> findById(Long id);
	
	public void delateById(Long id);
}
