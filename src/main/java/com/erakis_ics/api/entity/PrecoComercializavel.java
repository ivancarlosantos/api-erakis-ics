package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "preco_comercializavel")
public class PrecoComercializavel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prccm_id")
	private Long id;
	
	@Column(name = "prccm_codigo")
	private String codigo;
	
	@Column(name = "prccm_descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prccm_tabela_preco_id")
	private TabelaPreco tabelaPreco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prccm_comercializavel_id")
	private Comercializavel comercializavel;
	
	@Column(name = "prccm_valor",precision = 19,scale = 4)
	private BigDecimal valorUnitario = BigDecimal.ZERO; //valor unitário p/ unidade medida
	
	@Column(name = "prccm_valor_unidade_medida",precision = 19,scale = 4)
	private BigDecimal valorUnidadeMedida = BigDecimal.ZERO;
	
	@Column(name = "prccm_valor_embalagem", precision = 19,scale = 4)
	private BigDecimal valorEmbalagem = BigDecimal.ZERO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prccm_unidade_medida_id")
	private UnidadeMedida unidadeMedida;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prccm_variacao_id")
	private VariacaoProduto variacao;
	
	@Column(name = "prccm_multiplicidade")
	private Double multiplicidade = 1d;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prccm_embalagem_id")
	private EmbalagemVariacaoProduto embalagem;
	
	@Column(name = "prccm_quantidade_minima",precision = 14,scale = 4)
	private BigDecimal quantidadeMinima;

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

	public TabelaPreco getTabelaPreco() {
		return tabelaPreco;
	}

	public void setTabelaPreco(TabelaPreco tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}

	public Comercializavel getComercializavel() {
		return comercializavel;
	}

	public void setComercializavel(Comercializavel comercializavel) {
		this.comercializavel = comercializavel;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorUnidadeMedida() {
		return valorUnidadeMedida;
	}

	public void setValorUnidadeMedida(BigDecimal valorUnidadeMedida) {
		this.valorUnidadeMedida = valorUnidadeMedida;
	}

	public BigDecimal getValorEmbalagem() {
		return valorEmbalagem;
	}

	public void setValorEmbalagem(BigDecimal valorEmbalagem) {
		this.valorEmbalagem = valorEmbalagem;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public VariacaoProduto getVariacao() {
		return variacao;
	}

	public void setVariacao(VariacaoProduto variacao) {
		this.variacao = variacao;
	}

	public Double getMultiplicidade() {
		return multiplicidade;
	}

	public void setMultiplicidade(Double multiplicidade) {
		this.multiplicidade = multiplicidade;
	}

	public EmbalagemVariacaoProduto getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(EmbalagemVariacaoProduto embalagem) {
		this.embalagem = embalagem;
	}

	public BigDecimal getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(BigDecimal quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
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
		PrecoComercializavel other = (PrecoComercializavel) obj;
		return Objects.equals(id, other.id);
	}
}
