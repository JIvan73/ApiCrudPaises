package com.mx.ApiCrudPaises.dominio;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "ESTADOS")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Estados {
	
	//Mapeo
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "CLIMA")
	private String clima;
		
		
	//////FetchType  --- Con esto le indicamos que la relacion debe ser cargada al momento
		///////CARDINALIDAD Muchos modelos pertenecen a 1 marca
		
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PAIS")
	Paises pais;
		
		
		
		

}
