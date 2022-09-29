package com.EquipeMain.AppFii.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EquipeMain.AppFii.models.Usuario;
import com.EquipeMain.AppFii.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired		
	private UsuarioRepository usuariorp;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/home");
		return mv;
		
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrarUsuario() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("login/cadastroUsuario");
		return mv;
	}
	
	@PostMapping("salvarUsuario")
	public ModelAndView salvarUser(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		usuario.setData_cad(Instant.now());
		usuariorp.save(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
	

}
