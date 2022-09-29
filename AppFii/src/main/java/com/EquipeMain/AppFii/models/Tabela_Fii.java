package com.EquipeMain.AppFii.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_fii", schema="appfii")
public class Tabela_Fii {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private String CODIGO;
	
	@Column(name = "SETOR")
	private String SETOR;
	
	@Column(name = "PRECO_ATUAL")
	private BigDecimal PRECO_ATUAL;	
	
	@Column(name = "LIQUIDEZ_DIARIA")
	private BigDecimal LIQUIDEZ_DIARIO;
	
	@Column(name = "DIVIDENDO")
	private BigDecimal DIVIDENDO;
	
	@Column(name = "DY")
	private BigDecimal DY;
	
	@Column(name = "DY(3M)")
	private BigDecimal DY_3M;
	
	@Column(name = "DY(6M)")
	private BigDecimal DY_6M;
	
	@Column(name = "DY(12M)")
	private BigDecimal DY_12M;
	
	@Column(name = "DY(3M)+")
	private BigDecimal DY_3M_PLUS;
	
	@Column(name = "DY(6M)+")
	private BigDecimal DY_6M_PLUS;
	
	@Column(name = "DY(12M)+")
	private BigDecimal DY_12M_PLUS;
	
	@Column(name = "DY_ANO")
	private BigDecimal DY_ANO;
	
	@Column(name = "VARIACAO_PRECO")
	private BigDecimal VARIACAO_PRECO;
	
	@Column(name = "RENTAB")
	private BigDecimal RENTAB;
	
	@Column(name = "RENTAB+")
	private BigDecimal RENTAB_PLUS;
	
	
	@Column (name = "VPA")
	private BigDecimal VPA;
	
	@Column (name = "P/VPA")
	private BigDecimal P_VPA;
	
	@Column (name = "DY+")
	private BigDecimal DY_PLUS;
	
	@Column (name = "VARIACAO")
	private BigDecimal VARIACAO;
	
	@Column(name = "RENTAB_PATRIMONIO")
	private BigDecimal RENTAB_PATRIMONIO;
	
	@Column(name = "RENTAB_PATRIMONIO+")
	private BigDecimal RENTAB_PATRIMONIO_PLUS;
	
	@Column(name = "VACANCIA")
	private BigDecimal VACANCIA;
	
	@Column(name = "VACANCIA+")
	private BigDecimal VACANCIA_PLUS;
	
	@Column(name = "QUANTIDADE")
	private Integer QUANTIDADE;

}
