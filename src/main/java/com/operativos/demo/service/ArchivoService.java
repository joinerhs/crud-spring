package com.operativos.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operativos.demo.interfaceService.IarchivoService;
import com.operativos.demo.interfaces.IArchivo;
import com.operativos.demo.modelo.Archivo;

@Service
public class ArchivoService implements IarchivoService{
	
	@Autowired
	private IArchivo data;
	
	@Override
	public List<Archivo> listar() {		
		return (List<Archivo>)data.findAll();
	}

	@Override
	public Optional<Archivo> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Archivo a) {
		int res=0;
		Archivo archivo = data.save(a);
		if(!archivo.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	
}
