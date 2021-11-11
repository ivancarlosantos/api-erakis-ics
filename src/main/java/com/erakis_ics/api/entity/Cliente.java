package com.erakis_ics.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clnt_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clnt_pessoa_id", unique = true)
	private Pessoa pessoa;	
	
	@JoinTable(name="cliente__tabela_preco",
			joinColumns={@JoinColumn(name="cltpr_clnt_id")},
	        inverseJoinColumns={@JoinColumn(name="cltpr_tbprc_id")})
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
	@OrderColumn(name = "cltpr_ordem")
	private List<TabelaPreco> tabelasPreco = new ArrayList<TabelaPreco>();

	@Column(name = "clnt_juros")
	private Double juros;
	
	@Column(name = "clnt_multa")
	private Double multa;
	
	@Column(name = "clnt_observacao_pedido", columnDefinition = "TEXT")
	private String observacaoPedido;
	
	@Column(name = "clnt_observacao",columnDefinition = "TEXT")
	private String observacao;
	
	@Column(name = "clnt_observacao_nfe", columnDefinition = "TEXT")
	private String observacaoNfe;
	
	@Column(name = "clnt_email_nota_fiscal")
	private String emailNotaFiscal;

	@ManyToMany(mappedBy = "contatosCliente", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<PessoaFisica> contatos = new HashSet<PessoaFisica>();
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "clnt_representante_id")
	//private Representante representante;
	
	@Column(name = "clnt_comissao_representante")
	private Double comissaoRepresentante;
	
	@Column(name = "clnt_dia_vencimento")
	private Integer diaVencimento;
	
	@Column(name = "clnt_mes_renovacao")
	private Integer diaRenovacao;
	
	@Column(name = "clnt_codigo_numerico")
	private Long codigoNumerico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<TabelaPreco> getTabelasPreco() {
		return tabelasPreco;
	}

	public void setTabelasPreco(List<TabelaPreco> tabelasPreco) {
		this.tabelasPreco = tabelasPreco;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public String getObservacaoPedido() {
		return observacaoPedido;
	}

	public void setObservacaoPedido(String observacaoPedido) {
		this.observacaoPedido = observacaoPedido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacaoNfe() {
		return observacaoNfe;
	}

	public void setObservacaoNfe(String observacaoNfe) {
		this.observacaoNfe = observacaoNfe;
	}

	public String getEmailNotaFiscal() {
		return emailNotaFiscal;
	}

	public void setEmailNotaFiscal(String emailNotaFiscal) {
		this.emailNotaFiscal = emailNotaFiscal;
	}

	public Set<PessoaFisica> getContatos() {
		return contatos;
	}

	public void setContatos(Set<PessoaFisica> contatos) {
		this.contatos = contatos;
	}

	/*
	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	} */

	public Double getComissaoRepresentante() {
		return comissaoRepresentante;
	}

	public void setComissaoRepresentante(Double comissaoRepresentante) {
		this.comissaoRepresentante = comissaoRepresentante;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Integer getDiaRenovacao() {
		return diaRenovacao;
	}

	public void setDiaRenovacao(Integer diaRenovacao) {
		this.diaRenovacao = diaRenovacao;
	}

	public Long getCodigoNumerico() {
		return codigoNumerico;
	}

	public void setCodigoNumerico(Long codigoNumerico) {
		this.codigoNumerico = codigoNumerico;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}
