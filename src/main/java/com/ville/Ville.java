package com.ville;

public class Ville {
	
	private String codeINSEE;
	private String commune;
	private String codePostal;
	private String libelle_acheminement;
	private String ligne5;
	private String longitude;
	private String latitude;
	
	
	public Ville(String codeINSEE, String commune, String codePostal, String libelle_acheminement, String ligne5,
			String longitude, String latitude) {
		this.codeINSEE = codeINSEE;
		this.commune = commune;
		this.codePostal = codePostal;
		this.libelle_acheminement = libelle_acheminement;
		this.ligne5 = ligne5;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Ville(String code,String commune,String codePostal) {
		this(code,commune,codePostal,"00000","00000","00000","00000");
	}
	
	public String toString() {
		return this.getCommune()+" : "+this.getCodePostal()+"\n";
	}
	
	public String getCodeINSEE() {
		return codeINSEE;
	}

	public void setCodeINSEE(String codeINSEE) {
		this.codeINSEE = codeINSEE;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
