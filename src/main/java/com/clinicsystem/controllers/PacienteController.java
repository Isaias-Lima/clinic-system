package com.clinicsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinicsystem.models.Paciente;
import com.clinicsystem.services.PacienteService;


@Controller
@RequestMapping(value="/admin/paciente")
public class PacienteController {
	
	
	@Autowired
	private PacienteService service;

	@GetMapping("buscar/paciente")
	public String buscarPorPaciente(@RequestParam("id") int nome, ModelMap modelMap,
			@SortDefault("nome") Pageable pageable) {
		modelMap.addAttribute("nome",
				((PacienteService) service).buscarPorRegistro(PageRequest.of(pageable.getPageNumber(), 10), nome));
		return "paciente/lista";
	}
		
	@GetMapping("/lista")
    public String listarPaginada(ModelMap model, @SortDefault("nome") Pageable pageable) {
        model.addAttribute("nome", service.buscarPaginado(PageRequest.of(pageable.getPageNumber(), 10)));
        return "paciente/lista";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar(Paciente nome) {
		return "paciente/cadastro";
	}
		
	@PostMapping("/salvar")
	public String salvar(@Valid Paciente nome, RedirectAttributes attr) {
		service.salvar(nome);
		attr.addFlashAttribute("success", "Paciente cadastrado com sucesso!");
		return "redirect:lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("Paciente", service.buscarPorId(id));
        return "paciente/cadastro";
	}
	
    @PostMapping("/editar")
    public String editar(@Valid Paciente nome, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.salvar(nome);
        attr.addFlashAttribute("success", "Paciente atualizado com sucesso!");
        return "redirect:lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id, RedirectAttributes attr) {
    	service.excluir(id);
        attr.addFlashAttribute("success", "Paciente " + Paciente.getNome() + " excluído com sucesso!");
        return "redirect:/admin/paciente/lista";
    }
	
	
}
