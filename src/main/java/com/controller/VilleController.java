package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Ville;
import com.model.VilleModel;
import com.repository.VilleRepo;

@RestController
public class VilleController {
	/*
	 * -Rentrer les requêtes sur postman pour faire les test
	 */
	@Autowired
	private VilleRepo villeRepo;
	
	public VilleController(VilleRepo villerepo) {
		this.villeRepo = villerepo;
	}
	
	//Fonction pour récupérer le contenu de la BDD
	@GetMapping("ville")
	public List<Ville> get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		if(codePostal == null) {
			return this.villeRepo.findAll();
		}
		else {
			return this.villeRepo.findAllByCodePostal(codePostal);
		}
	}
	
	//Fonction pour enregistrer dans la BDD
	@PostMapping("AjouterVille")
	public String add(
			@RequestBody VilleModel ville
			){
		this.villeRepo.save(new Ville(ville));
		return "Ville ajoutée";
	}
	
	//Fonction pour delete dans la BDD
	@DeleteMapping("SupprimerVille/{codeINSEE}")
	public String delete(
			@PathVariable String codeINSEE
			){
		this.villeRepo.deleteByCodeINSEE(codeINSEE);
		return "Suppression effectuée";
	}
	
	//Fonction pour update dans la BDD
	@PutMapping("UpdateVille/{codeINSEE}")
	public String update(
			@RequestBody VilleModel ville,
			@PathVariable String codeINSEE
			) {
		Ville villeBDD = this.villeRepo.getByCodeINSEE(codeINSEE);
		villeBDD.setCommune(ville.getCommune());
		villeBDD.setCodePostal(ville.getCodePostal());
		villeBDD.setLibelleAcheminement(ville.getLibelleAcheminement());
		villeBDD.setLigne5(ville.getLigne5());
		villeBDD.setLatitude(ville.getLatitude());
		villeBDD.setLongitude(ville.getLongitude());
		this.villeRepo.save(villeBDD);
		return "Update effectuée";
	}

}