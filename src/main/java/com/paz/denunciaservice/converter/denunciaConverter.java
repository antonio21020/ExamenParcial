package com.paz.denunciaservice.converter;

import org.springframework.stereotype.Component;

import com.paz.denunciaservice.DTO.denunciaDTO;
import com.paz.denunciaservice.entity.denuncia;

@Component
public class denunciaConverter extends AbstractConverter<denuncia, denunciaDTO>{
	
	@Override
	public denunciaDTO fromEntity(denuncia entity) {
		if(entity==null) return null;
		return denunciaDTO.builder()
				.id(entity.getId())
				.Dni(entity.getDni())
				.fecha(entity.getFecha())
				.direccion(entity.getDireccion())
				.descripcion(entity.getDescripcion())
				.titulo(entity.getTitulo())
				.build();
	}

	@Override
	public denuncia fromDTO(denunciaDTO dto) {
		if(dto==null) return null;
		return denuncia.builder()
				.id(dto.getId())
				.Dni(dto.getDni())
				.fecha(dto.getFecha())
				.direccion(dto.getDireccion())
				.descripcion(dto.getDescripcion())
				.titulo(dto.getTitulo())
				.build();
	}

}
