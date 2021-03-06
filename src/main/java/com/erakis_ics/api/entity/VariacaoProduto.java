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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "variacao_produto")   
public class VariacaoProduto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vrcpd_id")
	private Long id;
	
	@Column(name = "vrcpd_codigo")
	private String codigo;
	
	@Column(name = "vrcpd_multiplo")
	private Double multiplicidade = 1d;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vrcpd_produto_id")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vrcpd_unidade_medida_id")
	private UnidadeMedida unidadeMedida;
	
	@Column(name = "vrcpd_peso_bruto")
	private Double pesoBruto;
	
	@Column(name = "vrcpd_peso_liquido")
	private Double pesoLiquido;
	
	@Column(name = "vrcpd_valor_custo_medio", precision = 19,scale = 4)
	private BigDecimal valorCustoMedio = BigDecimal.ZERO;
	
	@Column(name = "vrcpd_valor_custo", precision = 19, scale = 4)
	private BigDecimal valorCusto = BigDecimal.ZERO;
	
	@Column(name = "vrcpd_preco_base",precision = 19,scale = 4)
	private BigDecimal precoBase = BigDecimal.ZERO; //preço de Venda
	
	@Column(name = "vrcpd_desconto_maximo")
	private Double descontoMaximo;
	
	@Column(name = "vrcpd_comissao")
	private Double comissao;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "variacao",fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<EmbalagemVariacaoProduto> embalagens = new HashSet<EmbalagemVariacaoProduto>();
		
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "variacao")
	private Set<PrecoComercializavel> precos = new HashSet<PrecoComercializavel>();
	
	@Column(name = "vrcpd_informacoes_adicionais", columnDefinition = "TEXT")
	private String informacoesAdicionais;

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

	public Double getMultiplicidade() {
		return multiplicidade;
	}

	public void setMultiplicidade(Double multiplicidade) {
		this.multiplicidade = multiplicidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Double getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public BigDecimal getValorCustoMedio() {
		return valorCustoMedio;
	}

	public void setValorCustoMedio(BigDecimal valorCustoMedio) {
		this.valorCustoMedio = valorCustoMedio;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}

	public Double getDescontoMaximo() {
		return descontoMaximo;
	}

	public void setDescontoMaximo(Double descontoMaximo) {
		this.descontoMaximo = descontoMaximo;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Set<EmbalagemVariacaoProduto> getEmbalagens() {
		return embalagens;
	}

	public void setEmbalagens(Set<EmbalagemVariacaoProduto> embalagens) {
		this.embalagens = embalagens;
	}

	public Set<PrecoComercializavel> getPrecos() {
		return precos;
	}

	public void setPrecos(Set<PrecoComercializavel> precos) {
		this.precos = precos;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
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
		VariacaoProduto other = (VariacaoProduto) obj;
		return Objects.equals(id, other.id);
	}	
}
