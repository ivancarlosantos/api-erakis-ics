package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.erakis_ics.api.entity.EmbalagemVariacaoProduto;
import com.erakis_ics.api.entity.PrecoComercializavel;
import com.erakis_ics.api.entity.Produto;
import com.erakis_ics.api.entity.UnidadeMedida;
import com.erakis_ics.api.entity.VariacaoProduto;

public class VariacaoProdutoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String codigo;
	private Double multiplicidade = 1d;
	private Produto produto;
	private UnidadeMedida unidadeMedida;
	private Double pesoBruto;
	private Double pesoLiquido;
	private BigDecimal valorCustoMedio = BigDecimal.ZERO;
	private BigDecimal valorCusto = BigDecimal.ZERO;
	private BigDecimal precoBase = BigDecimal.ZERO; //preço de Venda
	private Double descontoMaximo;
	private Double comissao;
	private Set<EmbalagemVariacaoProduto> embalagens = new HashSet<EmbalagemVariacaoProduto>();
	private Set<PrecoComercializavel> precos = new HashSet<PrecoComercializavel>();
	private String informacoesAdicionais;
	
	public VariacaoProdutoDTO() {
	}

	public VariacaoProdutoDTO(VariacaoProduto vp) {
		//this.id = vp.getId();
		this.codigo = vp.getCodigo();
		//this.multiplicidade = vp.getMultiplicidade();
		this.produto = vp.getProduto();
		this.unidadeMedida = vp.getUnidadeMedida();
		this.pesoBruto = vp.getPesoBruto();
		this.pesoLiquido = vp.getPesoLiquido();
		this.valorCusto = vp.getValorCusto();
		this.valorCustoMedio = vp.getValorCustoMedio();
		//this.precoBase = vp.getPrecoBase();
		//this.descontoMaximo = vp.getDescontoMaximo();
		//this.comissao = vp.getComissao();
		//this.embalagens = vp.getEmbalagens();
		this.precos = vp.getPrecos();
		this.informacoesAdicionais = vp.getInformacoesAdicionais();
	}

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
		VariacaoProdutoDTO other = (VariacaoProdutoDTO) obj;
		return Objects.equals(id, other.id);
	}	
}
