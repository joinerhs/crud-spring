package com.operativos.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operativos.demo.modelo.Archivo;


@Repository
public interface IArchivo extends CrudRepository<Archivo, Integer> {

}
