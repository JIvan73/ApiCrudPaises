package com.mx.ApiCrudPaises.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiCrudPaises.dao.PaisesDao;
import com.mx.ApiCrudPaises.dominio.Paises;

@Service
public class PaisesImp implements PaisesServ{

	
	@Autowired
	PaisesDao dao;
	
	@Transactional (readOnly = true)
	@Override
	public List<Paises> listar() {
		// TODO Auto-generated method stub
		return (List<Paises>) dao.findAll();
	}

	@Transactional
	@Override
	public String guardar(Paises pais) {
		// TODO Auto-generated method stub
		
		String respuesta = "";
		boolean bandera = false;
		for (Paises p: dao.findAll()) {
			
////////todos los tipos de datos primitivos y estan parseados  se compara con un equals(todas las cadenas)
			if(p.getId().equals(pais.getId())) {
				respuesta = "Existe Id";
				bandera = true;
				break;
			} else if (p.getNombre().equals(pais.getNombre())) {
				respuesta="Existe Nombre";
				bandera = true;
				break;
			}
		}
		if(bandera=false)
		dao.save(pais);
		return respuesta;
	}

	
	@Transactional
	@Override
	public Paises buscar(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
	

	@Transactional
	@Override
	public boolean editar(Paises pais) {
		// TODO Auto-generated method stub
		for(Paises p:dao.findAll()) {
			if(p.getId().equals(pais.getId())) {
				dao.save(pais);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub

		for(Paises p:dao.findAll()) {
			if(p.getNombre().equals(id)) {
				dao.deleteById(id);
				//dao.delete(m);
				return true;
			}
		}
		return false;
	}

}
