package com.paz.denunciaservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.paz.denunciaservice.entity.denuncia;



public interface denunciaServices {
	public List<denuncia> findAll(Pageable page);
	public List<denuncia> findByNombre(String titulo ,Pageable page);
	public denuncia findById(int id);
	public denuncia save(denuncia denuncia);
	public denuncia update(denuncia denuncia);
	public void delete(int id);
	List<denuncia> findById(Integer Id, Pageable page);

}
