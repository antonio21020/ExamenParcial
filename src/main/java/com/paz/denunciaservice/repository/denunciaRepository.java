package com.paz.denunciaservice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.paz.denunciaservice.entity.denuncia;

public interface denunciaRepository extends JpaRepository<denuncia, Integer>{
	List<denuncia> findByIdContaining(Integer id,Pageable page);

}
