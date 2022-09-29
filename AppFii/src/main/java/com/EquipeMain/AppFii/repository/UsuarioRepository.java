package com.EquipeMain.AppFii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EquipeMain.AppFii.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	@Query("select i from Usuario i where i.email =:email")
	public  Usuario findByEmail(String email);
	
	
	
	@Query("select j from Usuario j where j.email =:email and j.senha =:senha")
	public Usuario buscarLogin(String email, String senha); 
		
		
		
	
	
	

}
