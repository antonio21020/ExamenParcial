package com.paz.denunciaservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paz.denunciaservice.entity.denuncia;
import com.paz.denunciaservice.repository.denunciaRepository;
import com.paz.denunciaservice.service.denunciaServices;


@Service
public class denunciaServiceImpl implements denunciaServices{
	@Autowired
	private denunciaRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<denuncia> findAll(Pageable page) {
		try {
			return repository.findAll(page).toList();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<denuncia> findById(Integer Id, Pageable page) {
		try {
			return repository.findByIdContaining(Id,page);
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public denuncia findById(int id) {
		try {
			denuncia registro= repository.findById(id).orElseThrow();
			return registro;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public denuncia save(denuncia denuncia) {
		try {
			//CarritoCompraValidator.save(denuncia);
			denuncia.setActivo(true);
			denuncia registro=repository.save(denuncia);
			return registro;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public denuncia update(denuncia denuncia) {
		try {
			//DenunciaValidator.save(denuncia);
			denuncia registro = repository.findById(denuncia.getId()).orElseThrow();
			registro.setDni(denuncia.getDni());
			registro.setFecha(denuncia.getFecha());
			registro.setTitulo(denuncia.getTitulo());
			registro.setDireccion(denuncia.getDireccion());
			registro.setDescripcion(denuncia.getDescripcion());
			repository.save(registro);
			return registro;
		
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(int id) {
		try {
			denuncia registro = repository.findById(id).orElseThrow();
			repository.delete(registro);
		}catch(Exception e) {
		}
		
	}

	@Override
	public List<denuncia> findByNombre(String titulo, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
