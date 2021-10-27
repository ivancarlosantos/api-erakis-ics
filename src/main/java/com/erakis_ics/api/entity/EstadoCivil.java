package com.erakis_ics.api.entity;

public enum EstadoCivil {

		SOLTEIRO("Solteiro(a)"),
		CASADO("Casado(a)"),
		SEPARADO("Separado(a)"),
		DIVORCIADO("Divorciado(a)"),
		VIUVO("Viúvo(a)"),
		UNIAO_ESTAVEL("União estável"),
		DESQUITADO("Desquitado(a)"),
		OUTROS("Outros");
		
		private final String label;
		private EstadoCivil(String label) {
			this.label = label;
		}
		public String getLabel() {
			return label;
		}
		
		public boolean isConjuge(){
			if(this.equals(CASADO) || this.equals(UNIAO_ESTAVEL) || this.equals(OUTROS)){
				return true;
			}else{
				return false;
			}
		}	
}
