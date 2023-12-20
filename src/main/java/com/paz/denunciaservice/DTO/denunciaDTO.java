package com.paz.denunciaservice.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class denunciaDTO {
	private int id;
	private String Dni;
	private Date fecha;
	private String titulo;
	private String direccion;
	private String descripcion;
}
