package com.kayolera.gestaoconvidado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kayolera.gestaoconvidado.model.Convidado;
import com.kayolera.gestaoconvidado.repository.ConvidadoRepository;

@Controller
public class ConvidadosController {
	
	@Autowired
    private	ConvidadoRepository reposito;
	
	@GetMapping("/")
	public ModelAndView listar() {
		var view = new ModelAndView("ListaConvidados");
		view.addObject("convidados", reposito.findAll());
		view.addObject("convidado",new Convidado());
		view.addObject("cont",5);
		return view;
	}
	
	@PostMapping("/convidados")
	public String salva(@Valid Convidado co , BindingResult  erro) { 
		if(!erro.hasErrors()) {
			reposito.save(co);
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/convidados/{id}")
	public String apagar(@PathVariable Long id) {
		
		if(reposito.existsById(id)) {
			reposito.deleteById(id);
		}
		return "redirect:/";
	}

}
