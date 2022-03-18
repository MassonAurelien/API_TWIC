package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.daoFactory;
import com.dao.daoVille;
import com.ville.Ville;

@RestController
public class VilleController {
	
	/*
	 * -Rentrer les requêtes sur postman pour faire les test
	 * -Voir Lombok pour code auto
	 */

	//Fonction pour récupérer le contenu de la BDD
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	public String get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		//Cette partie peut être inclue dans un BLO (Partie qui récurère les données)
		daoFactory daoFactory = new daoFactory();
		daoFactory.getInstance();
		daoVille daoVille = daoFactory.getDaoVille();
		//
		//Ensuite dans cette méthode, on gère l'affichage et le transfert des données vers la page
		List<Ville> ville = new ArrayList<Ville>();
		try {
			ville = daoVille.lire(codePostal);
			return ville.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Fail";
	}
	
	/*
	 * Voir aussi ResponseBody : Spring détecte le JSON(parametre POSTMAN) et le Map en l'objet passé en param
	 */
	//Fonction pour enregistrer dans la BDD
	@RequestMapping(value="/AjouterVille", method=RequestMethod.POST)
	public String post(@RequestParam(required  = true, value="code") String code,@RequestParam(required  = true, value="commune") String commune, @RequestParam(required  = true, value="codePostal")String codePostal) {
		daoFactory daoFactory = new daoFactory();
		daoFactory.getInstance();
		daoVille daoVille = daoFactory.getDaoVille();
		Ville ville = new Ville(code,commune,codePostal);
		daoVille.ajouter(ville);
		return "Insertion faite";
	}

}