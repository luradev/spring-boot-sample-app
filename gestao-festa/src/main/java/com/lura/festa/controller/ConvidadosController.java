package com.lura.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lura.festa.model.Convidado;
import com.lura.festa.repository.ConvidadoRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private ConvidadoRepository convidados;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());

		return modelAndView;
	}

	@PostMapping
	public String salvar(Convidado convidado) {
		
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}

}
