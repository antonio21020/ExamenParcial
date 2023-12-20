package com.paz.denunciaservice.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "denuncia")
public class denuncia {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 	
	 	@Column(unique = true,nullable = false, length=8)
	    private String Dni;
	 	
	 	@Column(name = "fecha",nullable = false)
	    private Date fecha;
	 	
	 	@Column(name = "titulo",nullable = false, length = 30)
	    private String titulo;
	 	
	 	@Column(name = "direccion",nullable = false, length = 200)
	    private String direccion;
	 	
	 	@Column(name = "descripcion",nullable = true, length = 255)
	    private String descripcion;
	 	
	 	 @Column(name = "created_at", nullable = false, updatable = false)
	     @Temporal(TemporalType.TIMESTAMP)
	     @CreatedDate
	     private Date createdAt;

	     @Column(name = "updated_at")
	     @Temporal(TemporalType.TIMESTAMP)
	     @LastModifiedDate
	     private Date updatedAt;
	     
	     @Column(name="activo",nullable = false)
	     private Boolean activo;
	 	
}
