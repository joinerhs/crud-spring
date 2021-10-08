package com.operativos.demo.interfaceService;


import java.util.List;
import java.util.Optional;

import com.operativos.demo.modelo.Archivo;

public interface IarchivoService {
	public List<Archivo>listar();
	public Optional<Archivo>listarId(int id);
	public int save(Archivo f);
	public void delete(int id);
}
