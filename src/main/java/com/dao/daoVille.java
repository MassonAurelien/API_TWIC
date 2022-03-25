package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ville.Ville;

public class daoVille {
private daoFactory daoFactory;
	
	public daoVille(daoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	public List<Ville> lire(String codePostal) throws Exception{
		Connection connexion = null;
		PreparedStatement preparedStatement = null;		
		ResultSet resultat = null;
		List<Ville> tab = new ArrayList<Ville>();
		if(codePostal == null) {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT Code_commune_INSEE,Nom_commune,Code_postal,Libelle_acheminement,Ligne_5,Latitude,Longitude from ville_france;");
			resultat = preparedStatement.executeQuery();
			while(resultat.next()) {
				Ville ville = new Ville(resultat.getString("Code_commune_INSEE"),resultat.getString("Nom_commune"),resultat.getString("Code_postal"),resultat.getString("Libelle_acheminement"),
						resultat.getString("Ligne_5"),resultat.getString("Latitude"),resultat.getString("Longitude"));
				tab.add(ville);
				
			}
			return tab;
		}
		else {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT Code_commune_INSEE,Nom_commune,Code_postal,Libelle_acheminement,Ligne_5,Latitude,Longitude from ville_france WHERE Code_postal LIKE ?;");
			preparedStatement.setString(1,codePostal);
			resultat = preparedStatement.executeQuery();
			while(resultat.next()) {
				Ville ville = new Ville(resultat.getString("Code_commune_INSEE"),resultat.getString("Nom_commune"),resultat.getString("Code_postal"),resultat.getString("Libelle_acheminement"),
						resultat.getString("Ligne_5"),resultat.getString("Latitude"),resultat.getString("Longitude"));
				tab.add(ville);
			}
			return tab;
		}
		//TODO Gerer les erreurs
	}

	public void ajouter(Ville ville){
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO ville_france VALUES (?,?,?,?,?,?,?);");
			preparedStatement.setString(1,ville.getCodeINSEE());
			preparedStatement.setString(2,ville.getCommune());
			preparedStatement.setString(3,ville.getCodePostal());
			preparedStatement.setString(4,ville.getLibelle_acheminement());
			preparedStatement.setString(5,ville.getLigne5());
			preparedStatement.setString(6,ville.getLatitude());
			preparedStatement.setString(7,ville.getLongitude());
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
