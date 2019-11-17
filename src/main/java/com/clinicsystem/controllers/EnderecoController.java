package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.Endereco;
import com.clinicsystem.services.EnderecoService;

@Controller
@RequestMapping(value="/admin/endereco")
public class EnderecoController {
	

		@Autowired
		private EnderecoService service;
		
		@GetMapping("/cadastro")
		public String cadastrar(Endereco endereco) {
			return "endereco/cadastro";
		}
		
		@PostMapping("/salvar")
		public String salvar(@Valid Endereco endereco) {
			service.salvar(endereco);
			return "redirect:cadastro";
		}

}
