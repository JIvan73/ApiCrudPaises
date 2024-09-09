package com.mx.ApiCrudPaises.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiCrudPaises.dominio.Paises;
import com.mx.ApiCrudPaises.servicio.PaisesImp;

@RestController
@RequestMapping(path = "PaisesWs")
@CrossOrigin

public class PaisesWs {
	
	///Inyeccion de dependencia
	@Autowired
	PaisesImp imp;
	
	
	//http://localhost:9000/PaisesWs/listar
	@GetMapping(path = "listar")
	public List<Paises> listarRegistros(){
		return imp.listar();
		
	}
	
	
	//http://localhost:9000/PaisesWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Paises pais){
		String respuesta = imp.guardar(pais);
		if(respuesta.equals("Existe id"))
			return new ResponseEntity<String>("Esa clave ya existe", HttpStatus.OK);
		else if(respuesta.equals("Existe el nombre"))
			return new ResponseEntity<String>("Ese nombre ya existe", HttpStatus.OK);
		else {
			return new ResponseEntity<> (pais, HttpStatus.CREATED);
		}	
	}
	
	
	//http://localhost:9000/PaisesWs/buscar
	@PostMapping(path = "buscar")
	public Paises buscar(@RequestBody Paises pais) {
		return imp.buscar(pais.getId());
	}
	
	
	//http://localhost:9000/PaisesWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Paises pais){
		
		boolean respuesta = imp.editar(pais);
		if(respuesta == false)
			return new ResponseEntity<String>("Ese Registro no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<>(pais, HttpStatus.CREATED);
		}
		
	}
	
	
	//http://localhost:9000/PaisesWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Paises pais){
		
		boolean respuesta = imp.eliminar(pais.getId());
		if(respuesta == false)
			return new ResponseEntity<String>("Ese Registro no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
		}
	}
	

}
