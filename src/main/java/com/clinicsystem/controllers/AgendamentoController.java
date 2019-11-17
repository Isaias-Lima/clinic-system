package com.clinicsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinicsystem.models.Agendamento;
import com.clinicsystem.models.Medico;
import com.clinicsystem.services.AgendamentoService;
import com.clinicsystem.services.MedicoService;

@Controller
@RequestMapping(value="/admin/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService service;
	
	@Autowired
	private MedicoService medicoService;
	
	
	@GetMapping("buscar/medico")
	public String buscarPorMedico(@RequestParam("medico") Medico medico, ModelMap modelMap,
			@SortDefault("medico") Pageable pageable) {
		modelMap.addAttribute("agendamento",
				service.buscarPorMedico(PageRequest.of(pageable.getPageNumber(), 10), medico));
		return "agendamento/lista";
	}	

	@GetMapping("/lista")
    public String listarPaginada(ModelMap model, @SortDefault("id") Pageable pageable) {
        model.addAttribute("agendamento", service.buscarPaginado(PageRequest.of(pageable.getPageNumber(), 10)));
        return "agendamento/lista";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar(Agendamento agendamento) {
		return "agendamento/cadastro";
	}
		
	@PostMapping("/salvar")
	public String salvar(@Valid Agendamento agendamento) {
		service.salvar(agendamento);
		return "redirect:cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("agendamento", service.buscarPorId(id));
        return "agendamento/cadastro";
	}
	
    @PostMapping("/editar")
    public String editar(@Valid Agendamento agendamento, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.salvar(agendamento);
        attr.addFlashAttribute("success", "Agendamento atualizado com sucesso!");
        return "redirect:lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id, RedirectAttributes attr) {
    	Agendamento agendamento = service.buscarPorId(id).orElse(null);
        service.excluir(id);
        attr.addFlashAttribute("success", "Agendamento " + agendamento.getId() + " excluído com sucesso!");
        return "redirect:/admin/convenio/lista";
    }
	
    @ModelAttribute("medicos")
    public List<Medico> medicos(){
    	return medicoService.listarTodos();
    }
	
}
