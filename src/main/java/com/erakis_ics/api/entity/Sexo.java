package com.erakis_ics.api.entity;

public enum Sexo {
	
	MASCULINO("Masculino", "M"),
	FEMININO("Feminino", "F");
	
	private final String label;
	private final String abreviatura;
	private Sexo(String label, String abreviatura) {
		this.abreviatura = abreviatura;
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public String getAbreviatura() {
		return abreviatura;
	}

}
