package com.mx.ApiCrudPaises.servicio;

import java.util.List;

import com.mx.ApiCrudPaises.dominio.Estados;

public interface EstadosServ {
	
	public List<Estados> listar();
	public String guardar (Estados estado); ///validar que el id y nombre no se repitan -idmarcaexiste
	public Estados buscar (Long id);
	public String editar (Estados estado); //validar que el idmodelo existe y id marca
	public boolean eliminar(Long id); //validar que el id existe
		

}
