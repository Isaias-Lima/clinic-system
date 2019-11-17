package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.Evolucao;
import com.clinicsystem.services.EvolucaoService;

@Controller
@RequestMapping(value="/admin/evolucao")
public class EvolucaoController {
	
	@Autowired
	private EvolucaoService service;
	
	@GetMapping("/cadastro")
	public String cadastrar(Evolucao evolucao) {
		return "evolucao/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Evolucao evolucao) {
		service.salvar(evolucao);
		return "redirect:cadastro";
	}

}
