package com.erakis_ics.api.entity;

public enum Regiao {

	CENTRO_OESTE("Centro-Oeste"),
	NORDESTE("Nordeste"),
	NORTE("Norte"),
	SUDESTE("Sudeste"),
	SUL("Sul");
	
	private final String label;
	private Regiao(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
