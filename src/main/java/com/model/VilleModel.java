package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VilleModel {
	
	private String codeINSEE;
	private String commune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne5;
	private String longitude;
	private String latitude;
	
	
	public VilleModel(String codeINSEE, String commune, String codePostal, String libelleAcheminement, String ligne5,
			String longitude, String latitude) {
		super();
		this.codeINSEE = codeINSEE;
		this.commune = commune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne5 = ligne5;
		this.longitude = longitude;
		this.latitude = latitude;
	}
}
