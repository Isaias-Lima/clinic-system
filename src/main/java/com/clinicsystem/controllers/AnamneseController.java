package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.Anamnese;
import com.clinicsystem.services.AnamneseService;

@Controller
@RequestMapping(value="/admin/anamnese")
public class AnamneseController {
	

		@Autowired
		private AnamneseService service;
		
		@GetMapping("/lista")
	    public String listarPaginada(ModelMap model, @SortDefault("paciente") Pageable pageable) {
	        model.addAttribute("anamnese", service.buscarPaginado(PageRequest.of(pageable.getPageNumber(), 10)));
	        return "anamnese/lista";
		}
		
		@GetMapping("/cadastro")
		public String cadastrar(Anamnese anamnese) {
			return "anamnese/cadastro";
		}
		
		@PostMapping("/salvar")
		public String salvar(@Valid Anamnese anamnese) {
			service.salvar(anamnese);
			return "redirect:cadastro";
		}

}
