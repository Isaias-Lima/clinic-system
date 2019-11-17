package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.MedicoDias;
import com.clinicsystem.services.MedicoDiasService;

@Controller
@RequestMapping(value="/admin/medicodias")
public class MedicoDiasController {

	@Autowired
	private MedicoDiasService service;
	
	@GetMapping("/cadastro")
	public String cadastrar(MedicoDias medicodias) {
		return "medicodias/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid MedicoDias medicodias) {
		service.salvar(medicodias);
		return "redirect:cadastro";
	}
	
}
