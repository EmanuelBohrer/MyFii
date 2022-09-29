package com.EquipeMain.AppFii.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EquipeMain.AppFii.exceptions.CriptoExistException;
import com.EquipeMain.AppFii.exceptions.EmailExistsException;
import com.EquipeMain.AppFii.models.Usuario;
import com.EquipeMain.AppFii.repository.UsuarioRepository;
import com.EquipeMain.AppFii.util.Util;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository rp;
	
	
	public void salvarUsuario(Usuario user) throws Exception{
		
		try {
			
			if(rp.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Esse email já está cadastro : "+ user.getEmail());
				
			}
			
			user.setSenha(Util.md5(user.getSenha()));
			
			
		}catch(NoSuchAlgorithmException e){
			throw new CriptoExistException("Erro na criptografia da senha.");
			
		}
		rp.save(user);
		
		
		
	}
	
	public Usuario loginUser(String user, String senha) throws ServiceExc{
		
		Usuario userLogin = rp.buscarLogin(user, senha);
		return userLogin;
		
	}
	
	

	
	
}
