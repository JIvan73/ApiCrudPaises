package com.mx.ApiCrudPaises.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.ApiCrudPaises.dominio.Paises;

public interface PaisesDao extends CrudRepository<Paises, Long>{

}
