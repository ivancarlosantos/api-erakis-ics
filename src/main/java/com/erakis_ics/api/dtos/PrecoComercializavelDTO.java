package com.erakis_ics.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.erakis_ics.api.entity.PrecoComercializavel;

public class PrecoComercializavelDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String codigo;
	private String descricao;
	//private TabelaPreco tabelaPreco;
	//private Comercializavel comercializavel;
	private BigDecimal valorUnitario = BigDecimal.ZERO; //valor unitário p/ unidade medida
	private BigDecimal valorUnidadeMedida = BigDecimal.ZERO;
	//private BigDecimal valorEmbalagem = BigDecimal.ZERO;
	//private UnidadeMedida unidadeMedida;
	//private VariacaoProduto variacao;
	//private Double multiplicidade = 1d;
	//private EmbalagemVariacaoProduto embalagem;
	//private BigDecimal quantidadeMinima;
	private BigDecimal quantidade = BigDecimal.ONE;
	private Double desconto = Double.valueOf(0d);
	private Double descontoMaximo = 0d;
	private BigDecimal fatorUnidadeMedida = BigDecimal.ONE;
	private BigDecimal valorPreco;
	
	public PrecoComercializavelDTO() {
	}
	

	public PrecoComercializavelDTO(PrecoComercializavel pc) {
		this.id = pc.getId();
		this.codigo = pc.getCodigo();
		this.descricao = pc.getDescricao();
		//this.tabelaPreco = pc.getTabelaPreco().getPrecos();
		//this.comercializavel = pc.getComercializavel();
		this.valorUnitario = pc.getValorUnitario();
		this.valorUnidadeMedida = pc.getValorUnidadeMedida();
		this.descontoMaximo = pc.getDescontoMaximo();
		//this.valorEmbalagem = pc.getValorEmbalagem();
		//this.unidadeMedida = unidadeMedida;
		//this.variacao = pc.getVariacao();
		//this.multiplicidade = pc.getMultiplicidade();
		//this.embalagem = pc.getEmbalagem();
		//this.quantidadeMinima = pc.getQuantidadeMinima();
		this.quantidade = pc.getQuantidade();
		//this.desconto = pc.getDesconto();
		//this.fatorUnidadeMedida = pc.getFatorUnidadeMedida();
		//this.valorPreco = pc.getValorPreco();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	/*public TabelaPreco getTabelaPreco() {
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
	} */

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getFatorUnidadeMedida() {
		return fatorUnidadeMedida;
	}

	public void setFatorUnidadeMedida(BigDecimal fatorUnidadeMedida) {
		this.fatorUnidadeMedida = fatorUnidadeMedida;
	}

	public BigDecimal getValorPreco() {
		return valorPreco;
	}

	public void setValorPreco(BigDecimal valorPreco) {
		this.valorPreco = valorPreco;
	}
	
	public Double getDescontoMaximo() {
		return descontoMaximo;
	}


	public void setDescontoMaximo(Double descontoMaximo) {
		this.descontoMaximo = descontoMaximo;
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
		PrecoComercializavelDTO other = (PrecoComercializavelDTO) obj;
		return Objects.equals(id, other.id);
	}
}
