package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.Diagnostico;
import com.clinicsystem.services.DiagnosticoService;

@Controller
@RequestMapping(value="/admin/diagnostico")
public class DiagnosticoController {
	

		@Autowired
		private DiagnosticoService service;
		
		@GetMapping("/cadastro")
		public String cadastrar(Diagnostico diagnostico) {
			return "diagnostico/cadastro";
		}
		
		@PostMapping("/salvar")
		public String salvar(@Valid Diagnostico diagnostico) {
			service.salvar(diagnostico);
			return "redirect:cadastro";
		}

}
