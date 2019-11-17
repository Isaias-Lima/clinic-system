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

import com.clinicsystem.models.Especialidade;
import com.clinicsystem.services.EspecialidadeService;

@Controller
@RequestMapping(value="/admin/especialidade")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeService service;

	@GetMapping("/lista")
    public String listarPaginada(ModelMap model, @SortDefault("especialidade") Pageable pageable) {
        model.addAttribute("especialidade", service.buscarPaginado(PageRequest.of(pageable.getPageNumber(), 10)));
        return "especialidade/lista";
	}
	
	@GetMapping("buscar/especialidade")
	public String buscarPorEspecialidade(@RequestParam("especialidade") String especialidade, ModelMap modelMap,
			@SortDefault("especialidade") Pageable pageable) {
		modelMap.addAttribute("especialidade",
				service.buscarPorEspecialidade(PageRequest.of(pageable.getPageNumber(), 10), especialidade));
		return "especialidade/lista";
	}

	
	@GetMapping("/cadastro")
	public String cadastrar(Especialidade especialidade) {
		return "especialidade/cadastro";
	}
		
	@PostMapping("/salvar")
	public String salvar(@Valid Especialidade especialidade, RedirectAttributes attr) {
		service.salvar(especialidade);
		attr.addFlashAttribute("success", "Especialidade cadastrado com sucesso!");
		return "redirect:lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("especialidade", service.buscarPorId(id));
        return "especialidade/cadastro";
	}
	
    @PostMapping("/editar")
    public String editar(@Valid Especialidade especialidade, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.salvar(especialidade);
        attr.addFlashAttribute("success", "Especialidade atualizado com sucesso!");
        return "redirect:lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id, RedirectAttributes attr) {
    	Especialidade especialidade = service.buscarPorId(id).orElse(null);
        service.excluir(id);
        attr.addFlashAttribute("success", "Especialidade " + especialidade.getDescricao() + " excluído com sucesso!");
        return "redirect:/admin/especialidade/lista";
    }
	
	
}





