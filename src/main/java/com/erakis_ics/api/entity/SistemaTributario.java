package com.erakis_ics.api.entity;

public enum SistemaTributario {

	SIMPLES_NACIONAL("Simples Nacional", 1), 
	LUCRO_PRESUMIDO("Lucro Presumido", 3),
	LUCRO_REAL("Lucro Real", 3),
	SIMPLES_EXCESSO("Simples Nacional c/ Excesso", 2);

	private String label;
	private final int codigo;

	private SistemaTributario(String label, int codigo) {
		this.label = label;
		this.codigo = codigo;
	}

	public String getLabel() {
		return label;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean isSimplesNacional() {
		return this == SIMPLES_NACIONAL;
	}

	public boolean isSimplesExcesso() {
		return this == SIMPLES_EXCESSO;
	}

	public boolean isSimplesNacionalGeral() {
		return this == SIMPLES_NACIONAL || this == SIMPLES_EXCESSO;
	}

	public boolean isLucro() {
		return this == LUCRO_PRESUMIDO || this == LUCRO_REAL;
	}

	public boolean isCalculaSubstituicaoTributaria() {
		return isLucro() || this == SIMPLES_EXCESSO;
	}
}
