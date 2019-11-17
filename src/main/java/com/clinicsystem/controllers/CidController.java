package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinicsystem.models.Cid;
import com.clinicsystem.services.CidService;

@Controller
@RequestMapping(value="/admin/cid")
public class CidController {
	

		@Autowired
		private CidService service;
		
		@GetMapping("/cadastro")
		public String cadastrar(Cid cid) {
			return "cid/cadastro";
		}
		
		@PostMapping("/salvar")
		public String salvar(@Valid Cid cid) {
			service.salvar(cid);
			return "redirect:cadastro";
		}

}


