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

import com.clinicsystem.models.Convenio;
import com.clinicsystem.services.ConvenioService;

@Controller
@RequestMapping(value="/admin/convenio")
public class ConvenioController {
	
	@Autowired
	private ConvenioService service;

	@GetMapping("/lista")
    public String listarPaginada(ModelMap model, @SortDefault("convenio") Pageable pageable) {
        model.addAttribute("convenio", service.buscarPaginado(PageRequest.of(pageable.getPageNumber(), 10)));
        return "convenio/lista";
	}
	
	@GetMapping("buscar/convenio")
	public String buscarPorConvenio(@RequestParam("convenio") String convenio, ModelMap modelMap,
			@SortDefault("convenio") Pageable pageable) {
		modelMap.addAttribute("convenio",
				service.buscarPorConvenio(PageRequest.of(pageable.getPageNumber(), 10), convenio));
		return "convenio/lista";
	}

	
	@GetMapping("/cadastro")
	public String cadastrar(Convenio convenio) {
		return "convenio/cadastro";
	}
		
	@PostMapping("/salvar")
	public String salvar(@Valid Convenio convenio, RedirectAttributes attr) {
		service.salvar(convenio);
		attr.addFlashAttribute("success", "Convenio cadastrado com sucesso!");
		return "redirect:lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("convenio", service.buscarPorId(id));
        return "convenio/cadastro";
	}
	
    @PostMapping("/editar")
    public String editar(@Valid Convenio convenio, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "cadastro";
        }

        service.salvar(convenio);
        attr.addFlashAttribute("success", "Convenio atualizado com sucesso!");
        return "redirect:lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id, RedirectAttributes attr) {
    	Convenio convenio = service.buscarPorId(id).orElse(null);
        service.excluir(id);
        attr.addFlashAttribute("success", "Convenio " + convenio.getNomeConvenio() + " excluído com sucesso!");
        return "redirect:/admin/convenio/lista";
    }
	
	
}
