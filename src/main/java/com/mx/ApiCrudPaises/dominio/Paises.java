package com.mx.ApiCrudPaises.dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAISES")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Paises {
	
	///MAPEO DE CAMPOS DE LA TABLA
		@Id
		@Column(name = "ID")
		private Long id;
		@Column(name = "NOMBRE")
		private String nombre;
		@Column(name = "IDIOMA")
		private String idioma;
		
		
		@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
		@JsonIgnore
		List<Estados> lista = new ArrayList<>();
	

}
