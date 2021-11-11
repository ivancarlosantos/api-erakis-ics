package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "embalagem")
public class Embalagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emblg_id")
	private Long id;
	
	@Column(name = "emblg_codigo")
	private String codigo;
	
	@Column(name = "emblg_descricao")
	private String descricao;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emblg_variacao_produto_id")
	private VariacaoProduto variacaoProduto;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "embalagem", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<EmbalagemVariacaoProduto> variacoesProduto = new HashSet<EmbalagemVariacaoProduto>();
	
	@Column(name = "emblg_largura")
	private BigDecimal largura;
	
	@Column(name = "emblg_comprimento")
	private BigDecimal comprimento;
	
	@Column(name = "emblg_altura")
	private BigDecimal altura;
	
	@Column(name = "emblg_profundidade")
	private BigDecimal profundidade;
	
	@Column(name = "emblg_diametro")
	private BigDecimal diametro;
	
	@Column(name = "emblg_peso")
	private BigDecimal peso;
	
	@Column(name = "emblg_peso_maximo")
	private BigDecimal pesoMaximo;
	
	@Column(name = "emblg_capacidade_empilhamento")
	private BigDecimal capacidadeEmpilhamento;
	
	@Column(name = "emblg_embalagem_expedicao")
	private Boolean embalagemExpedicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public VariacaoProduto getVariacaoProduto() {
		return variacaoProduto;
	}

	public void setVariacaoProduto(VariacaoProduto variacaoProduto) {
		this.variacaoProduto = variacaoProduto;
	}

	public Set<EmbalagemVariacaoProduto> getVariacoesProduto() {
		return variacoesProduto;
	}

	public void setVariacoesProduto(Set<EmbalagemVariacaoProduto> variacoesProduto) {
		this.variacoesProduto = variacoesProduto;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(BigDecimal profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(BigDecimal pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public BigDecimal getCapacidadeEmpilhamento() {
		return capacidadeEmpilhamento;
	}

	public void setCapacidadeEmpilhamento(BigDecimal capacidadeEmpilhamento) {
		this.capacidadeEmpilhamento = capacidadeEmpilhamento;
	}

	public Boolean getEmbalagemExpedicao() {
		return embalagemExpedicao;
	}

	public void setEmbalagemExpedicao(Boolean embalagemExpedicao) {
		this.embalagemExpedicao = embalagemExpedicao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Embalagem other = (Embalagem) obj;
		return Objects.equals(id, other.id);
	}
}
