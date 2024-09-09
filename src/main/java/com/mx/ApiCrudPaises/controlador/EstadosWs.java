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

import com.mx.ApiCrudPaises.dominio.Estados;
import com.mx.ApiCrudPaises.servicio.EstadosImp;

@RestController
@RequestMapping(path = "EstadosWs")
@CrossOrigin

public class EstadosWs {
	
	@Autowired
	EstadosImp imp;
	
	//http://localhost:9000/EstadosWs/listar
	@GetMapping(path = "listar")
	public List<Estados> litar(){
		return imp.listar();
	}
	
	
	//http://localhost:9000/EstadosWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<String> guardar(@RequestBody Estados estado){
		
		String responde = imp.guardar(estado);
		
		if(responde.equals("IdExiste"))
			return new ResponseEntity<String>("No se puede, IdEdo en existencia", HttpStatus.OK);
		else if(responde.equals("NombreExiste"))
			return new ResponseEntity<String>("No se puede, nombre Existe", HttpStatus.OK);
		else if(responde.equals("IdPaisExiste"))
			return new ResponseEntity<String>("No se puede, IdPais NO Existe", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Aceptado", HttpStatus.OK);
		}	
	}
	
	
	//http://localhost:9000/EstadosWs/buscar
	@PostMapping(path = "buscar")
	public Estados buscar (@RequestBody Estados estado) {
		
		return imp.buscar(estado.getId());
	}
	
	
	
	//http://localhost:9000/EstadosWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<String> editar (@RequestBody Estados estado){
		
		String responde = imp.editar(estado);
		if(responde.equals("IdExiste"))
			return new ResponseEntity<String>("Ese Registro no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Perfecto", HttpStatus.CREATED);
		}
		
	}
	
	
	
	//http://localhost:9000/EstadosWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> elimiar (@RequestBody Estados estado){
		
		boolean respuesta = imp.eliminar(estado.getId());
		if(respuesta == false)
			return new ResponseEntity<String>("Ese Registro no existe", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
		}
		
	}
	
	
	
	

}
