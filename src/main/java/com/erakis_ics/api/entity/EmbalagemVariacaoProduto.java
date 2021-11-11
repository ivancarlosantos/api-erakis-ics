package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "embalagem_variacao_produto")   
public class EmbalagemVariacaoProduto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "embvp_id")
	private Long id;
	
	@Column(name = "embvp_quantidade")
	private Double quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "embvp_embalagem_id")
	private Embalagem embalagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "embvp_variacao_id")
	private VariacaoProduto variacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}

	public VariacaoProduto getVariacao() {
		return variacao;
	}

	public void setVariacao(VariacaoProduto variacao) {
		this.variacao = variacao;
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
		EmbalagemVariacaoProduto other = (EmbalagemVariacaoProduto) obj;
		return Objects.equals(id, other.id);
	}
}
