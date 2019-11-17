package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.Clinica;
import com.clinicsystem.services.ClinicaService;

@Controller
@RequestMapping(value="/admin/clinica")
public class ClinicaController {
	

		@Autowired
		private ClinicaService service;
		
		@GetMapping("/cadastro")
		public String cadastrar(Clinica clinica) {
			return "clinica/cadastro";
		}
		
		@PostMapping("/salvar")
		public String salvar(@Valid Clinica clinica) {
			service.salvar(clinica);
			return "redirect:cadastro";
		}

}
