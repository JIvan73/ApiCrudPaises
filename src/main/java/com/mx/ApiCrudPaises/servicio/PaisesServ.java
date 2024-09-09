package com.mx.ApiCrudPaises.servicio;

import java.util.List;

import com.mx.ApiCrudPaises.dominio.Paises;

public interface PaisesServ {
	
	public List<Paises> listar();
	public String guardar (Paises pais); ///id y nombre no se repitan
	public Paises buscar (Long id);
	public boolean editar (Paises pais); /// validar que el id exista
	public boolean eliminar (Long id);  ///validar que el Id exista

}
