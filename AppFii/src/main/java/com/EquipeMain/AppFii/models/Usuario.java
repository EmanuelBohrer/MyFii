package com.EquipeMain.AppFii.models;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios", schema="appfii")
@Builder	
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
			
	private String nome;
	@Column (name = "email")
	
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "data_nasc")
	private Date data_nasc;
	
	@Column(name = "data_cad")
	private Instant data_cad;
	
	

	
	
	
	

}
