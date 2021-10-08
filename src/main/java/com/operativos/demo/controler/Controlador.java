package com.operativos.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.operativos.demo.interfaceService.IarchivoService;
import com.operativos.demo.modelo.Archivo;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IarchivoService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Archivo>archivos=service.listar();
		model.addAttribute("archivos", archivos);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("archivo", new Archivo());
		return "form";
	}
	@PostMapping("/save")
	public String save(@Validated Archivo a, Model model) {
		service.save(a);
		return "redirect:/listar";
	}
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Archivo>archivo=service.listarId(id);
		model.addAttribute("archivo", archivo); 
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id); 
		return "redirect:/listar";
	}
}
