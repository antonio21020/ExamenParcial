package com.paz.denunciaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paz.denunciaservice.entity.denuncia;
import com.paz.denunciaservice.service.denunciaServices;



@RestController
@RequestMapping("/denuncia/")
public class denunciaController {
	
	@Autowired
	private denunciaServices service;
	
	@GetMapping()
	public ResponseEntity<List<denuncia>> findAll(
			@RequestParam(value = "id", required = false,defaultValue = "")Integer id,
			@RequestParam(value = "offset", required = false,defaultValue = "0")int pageNumber,
			@RequestParam(value = "limit", required = false,defaultValue = "5")int pageSize
			
			){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<denuncia> denuncia;
		if(id==null) {
			denuncia=service.findAll(page);
		}else {
			denuncia=service.findById(id, page);
		}
		if(denuncia.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(denuncia);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<denuncia> findById(@PathVariable("id")int id){
		denuncia denuncia = service.findById(id);
		if(denuncia==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(denuncia);
	}
	@PostMapping()
	public ResponseEntity<denuncia> create(@RequestBody denuncia denuncia){
		denuncia registro=service.save(denuncia);
		return ResponseEntity.status(HttpStatus.CREATED).body(registro);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<denuncia> update(@PathVariable("id")int id,@RequestBody denuncia denuncia){
		denuncia registro=service.update(denuncia);
		if(registro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(registro);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<denuncia> delete(@PathVariable("id")int id){
		service.delete(id);
		return ResponseEntity.ok(null);
	}
	
	
	
}

