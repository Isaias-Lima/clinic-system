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

import com.clinicsystem.models.Medico;
import com.clinicsystem.services.MedicoService;

@Controller
@RequestMapping(value="/admin/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService service;

	@GetMapping("buscar/medico")
	public String buscarPorMedico(@RequestParam("medico") Medico medico, ModelMap modelMap,
			@SortDefault("medico") Pageable pageable) {
		modelMap.addAttribute("medico",
				service.buscarPorMedico(PageRequest.of(pageable.getPageNumber(), 10), medico));
		return "medico/lista";
	}
		
	@GetMapping("/lista")
    public String listarPaginada(ModelMap model, @SortDefault("medico") Pageable pageable) {
        model.addAttribute("medico", service.buscarPaginado(PageRequest.of(pageable.getPageNumber(), 10)));
        return "medico/lista";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar(Medico medico) {
		return "medico/cadastro";
	}
		
	@PostMapping("/salvar")
	public String salvar(@Valid Medico medico, RedirectAttributes attr) {
		service.salvar(medico);
		attr.addFlashAttribute("success", "Médico cadastrado com sucesso!");
		return "redirect:lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("medico", service.buscarPorId(id));
        return "medico/cadastro";
	}
	
    @PostMapping("/editar")
    public String editar(@Valid Medico medico, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.salvar(medico);
        attr.addFlashAttribute("success", "Medico atualizado com sucesso!");
        return "redirect:lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id, RedirectAttributes attr) {
    	Medico medico = service.buscarPorId(id).orElse(null);
        service.excluir(id);
        attr.addFlashAttribute("success", "Medico " + medico.getMedico() + " excluído com sucesso!");
        return "redirect:/admin/medico/lista";
    }

}
