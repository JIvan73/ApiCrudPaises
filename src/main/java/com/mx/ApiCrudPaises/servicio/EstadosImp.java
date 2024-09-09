package com.mx.ApiCrudPaises.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiCrudPaises.dao.EstadosDao;
import com.mx.ApiCrudPaises.dao.PaisesDao;
import com.mx.ApiCrudPaises.dominio.Estados;
import com.mx.ApiCrudPaises.dominio.Paises;

@Service
public class EstadosImp implements EstadosServ{

	@Autowired
	EstadosDao edosdao;
	
	@Autowired
	PaisesDao paisdao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Estados> listar() {
		// TODO Auto-generated method stub
		return (List<Estados>)edosdao.findAll();
	}

	
	@Transactional
	@Override
	public String guardar(Estados estado) {
		// TODO Auto-generated method stub
		///Id y nombre que no se repitan
		///id marca existe
		String respuesta = "";
		boolean banderaPa = false;
		boolean banderaEs = false;
		
		///recorrer registros de la tabla marcas
		for(Paises pa : paisdao.findAll()) {
			///iterar hasta que encuentre marca existe
			if(pa.getId().equals(estado.getPais().getId())) {
				banderaPa = true;
				
				//2do for Recorriendo en la tabla de modelos
				for(Estados es : edosdao.findAll()) {
					//Ese id existe
					if(es.getId().equals(estado.getId())) {
						respuesta = "Id Existe";
						banderaEs = true;
					} else if (es.getNombre().equals(estado.getNombre())) {
						respuesta = "existeNombre";
					}
				}
				break;
			}
		}
		
		if(banderaPa == false) {
			respuesta = "IdMarcaNoExiste";
			banderaEs = true;
		} else if (banderaEs == false) {
			edosdao.save(estado);
		}
		return respuesta;
	}

	
	
	@Transactional
	@Override
	public Estados buscar(Long id) {
		// TODO Auto-generated method stub
		return edosdao.findById(id).orElse(null);
	}

	
	
	@Transactional
	@Override
	public String editar(Estados estado) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean banderaPa = false;
		boolean banderaEs = false;
		
		///for tabla marcas
		for (Paises pa : paisdao.findAll()) {
			if(pa.getId().equals(estado.getPais().getId())) {
				banderaPa = true;
				
				//2do for Recorriendo en la tabla de modelos
				for(Estados es : edosdao.findAll()) {
					//id existe
					if(es.getId().equals(estado.getId())) {
						respuesta = "Id Existe";
						banderaEs = true;
					}
				}
				break;
			}
			
		}
		
		if(banderaPa == false) {
			respuesta = "IdPaisNoExiste";
			banderaEs = true;
		} else if (banderaEs == false) {
			edosdao.save(estado);
		}
		return respuesta;
	}

	
	
	
	@Transactional
	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub


		for(Estados es:edosdao.findAll()) {
			if(es.getNombre().equals(id)) {
				//modelodao.deleteById(id);
				edosdao.delete(es);
				return true;
			}
		}
		
		return false;
		
	}

}
