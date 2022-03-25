package com.ville;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ville_france")
public class Ville {
	
	
	@Id
	@Column(name="Code_commune_INSEE",nullable = true)
	private String codeINSEE;
	@Column(name="Nom_commune",nullable = true)
	private String commune;
	@Column(name="Code_postal",nullable = true)
	private String codePostal;
	@Column(name="Libelle_acheminement",nullable = true)
	private String libelle_acheminement;
	@Column(name="Ligne_5",nullable = true)
	private String ligne5;
	@Column(name="Longitude",nullable = true)
	private String longitude;
	@Column(name="Latitude",nullable = true)
	private String latitude;
	
	public String toString() {
		return codeINSEE+" "+commune+" "+codePostal+" "+libelle_acheminement+" "+ligne5+" "+latitude+" "+longitude;
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

	public Ville(String codeINSEE, String commune, String codePostal, String libelle_acheminement, String ligne5,
			String longitude, String latitude) {
		super();
		this.codeINSEE = codeINSEE;
		this.commune = commune;
		this.codePostal = codePostal;
		this.libelle_acheminement = libelle_acheminement;
		this.ligne5 = ligne5;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Ville() {
		super();
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
