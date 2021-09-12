package com.kilez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kilez.entity.Inventario;
import com.kilez.service.inventarioService;


@RestController
public class inventarioController  {

	@Autowired
	private inventarioService service;
	
	
	@GetMapping
	public ResponseEntity<?> listar() {
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> Crear(@RequestBody Inventario inventario) {
		Inventario inventarioDb = service.save(inventario);
		return ResponseEntity.status(HttpStatus.CREATED).body(inventarioDb);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> Editar(@RequestBody Inventario inventario, @PathVariable Long id){

		Optional<Inventario> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Inventario inventarioDb = o.get();
		
		inventarioDb.setArticulo(inventario.getArticulo());
		inventarioDb.setDescripcion(inventario.getDescripcion());
		inventarioDb.setCantidad(inventario.getCantidad());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inventarioDb));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Inventario> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
	
}
