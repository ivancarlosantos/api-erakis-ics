package com.erakis_ics.api.entity;

public enum TipoEndereco {

	COMERCIAL("Comercial"),
	RESIDENCIAL("Residencial"),
	ENTREGA("Entrega"),
	COBRANCA("Cobrança"),
	CORRESPONDENCIA("Correspondência"),
	PRINCIPAL("Principal"),
	SERVICO("Serviço");

	private String label;

	private TipoEndereco(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public boolean isPrincipal() {
		return this.equals(PRINCIPAL);
	}
	
	public static TipoEndereco[] getTiposEnderecoPessoaFisica(){
		return TipoEndereco.values();
	}

	public static TipoEndereco[] getTiposEnderecoPessoaJuridica(){
		TipoEndereco[] tipos = new TipoEndereco[4];
		tipos[0] = ENTREGA;
		tipos[1] = COBRANCA;
		tipos[2] = CORRESPONDENCIA;
		tipos[3] = PRINCIPAL;
		return tipos;
	}
}
