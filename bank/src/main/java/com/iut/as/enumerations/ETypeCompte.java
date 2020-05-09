package com.iut.as.enumerations;

public enum ETypeCompte {
	SANS_DECOUVERT(false, "SANS"), AVEC_DECOUVERT(true, "AVEC");

	private boolean decouvertAutorise;
	private String codeDescription;

	public String getCodeDescription() {
		return codeDescription;
	}

	public boolean getDecouvertAutorise() {
		return decouvertAutorise;
	}

	private ETypeCompte(boolean decouvertAutorise, String codeDescription) {
		this.decouvertAutorise = decouvertAutorise;
		this.codeDescription = codeDescription;
	}

	public static ETypeCompte getTypeAccordingString(String type) {
		if (AVEC_DECOUVERT.getCodeDescription().equals(type)) {
			return AVEC_DECOUVERT;
		}
		return SANS_DECOUVERT;
	}

}
