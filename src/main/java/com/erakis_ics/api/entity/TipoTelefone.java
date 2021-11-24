package com.erakis_ics.api.entity;

public enum TipoTelefone {
	
	RESIDENCIAL("Residencial", "Res."),
	CELULAR("Celular", "Cel."),
	COMERCIAL("Comercial", "Com."),
	RECADO("Recado", "Rec."),
	PRINCIPAL("Principal", "Pcpal."),
	FAX("Fax", "Fax");

	private final String label;
	private final String abreviacao;
	
	private TipoTelefone(String label, String abreaviacao) {
		this.label = label;
		this.abreviacao = abreaviacao;
	}
	public String getLabel() {
		return label;
	}
	public String getAbreviacao() {
		return abreviacao;
	}
	public boolean isPrincipal() {
		return this.equals(PRINCIPAL);
	}
	public boolean isFax() {
		return this.equals(FAX);
	}

	public static TipoTelefone[] getTiposEnderecoPessoaFisica(){
		return TipoTelefone.values();
	}
	public static TipoTelefone[] getTiposEnderecoPessoaJuridica(){
		TipoTelefone[] tipos = new TipoTelefone[3];
		tipos[0] = PRINCIPAL;
		tipos[1] = CELULAR;
		tipos[2] = FAX;
		return tipos;
	}
}
