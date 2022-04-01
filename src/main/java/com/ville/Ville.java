package com.ville;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	private String libelleAcheminement;
	@Column(name="Ligne_5",nullable = true)
	private String ligne5;
	@Column(name="Longitude",nullable = true)
	private String longitude;
	@Column(name="Latitude",nullable = true)
	private String latitude;
	
	public String toString() {
		return codeINSEE+" "+commune+" "+codePostal+" "+libelleAcheminement+" "+ligne5+" "+latitude+" "+longitude;
	}

	public Ville(String codeINSEE, String commune, String codePostal, String libelle_acheminement, String ligne5,
			String longitude, String latitude) {
		super();
		this.codeINSEE = codeINSEE;
		this.commune = commune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelle_acheminement;
		this.ligne5 = ligne5;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Ville() {
		super();
	}
}
