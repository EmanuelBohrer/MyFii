package com.EquipeMain.AppFii.controllers;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EquipeMain.AppFii.models.Usuario;
import com.EquipeMain.AppFii.repository.UsuarioRepository;
import com.EquipeMain.AppFii.service.ServiceExc;
import com.EquipeMain.AppFii.service.UsuarioService;
import com.EquipeMain.AppFii.util.Util;

@Controller
public class UsuarioController {
	
	@Autowired		
	private UsuarioRepository usuariorp;
	
	
	@Autowired
	private UsuarioService serviceUsuario;
	
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
	public ModelAndView salvarUser(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		usuario.setData_cad(Instant.now());
		serviceUsuario.salvarUsuario(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Validated Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("login/home");
		}
		Usuario userLogin = serviceUsuario.loginUser(usuario.getEmail(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			mv.addObject("msg","Usuário não cadastrado! Tente novamente.");
			
		}else {
			session.setAttribute("usuarioLogado", userLogin);
			return login();
		}
		return mv;		
	
		
	}
	
	
	@GetMapping("/login")
	public ModelAndView loginuser(Usuario usuario){
	ModelAndView mv = new ModelAndView("login/home");
	mv.addObject("usuario", usuario);
	return mv;
	}
	

}
