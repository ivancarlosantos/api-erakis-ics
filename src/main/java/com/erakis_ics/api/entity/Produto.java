package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@PrimaryKeyJoinColumn(name="prdt_id", referencedColumnName="cmrc_id")
public class Produto extends Comercializavel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prdt_unidade_medida_padrao_id")
	private UnidadeMedida unidadeMedidaPadrao;
	
	@Column(name = "prdt_unidade_padrao_variacao")
	private boolean unidadePadraoGeraVariacao = true;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "produto", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<VariacaoProduto> variacoes = new HashSet<VariacaoProduto>();	
}
