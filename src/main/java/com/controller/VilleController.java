package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//Fonction pour enregistrer dans la BDD
	@PostMapping("AjouterVille")
	public void post(
			@RequestBody VilleModel ville
			) {
		this.villeRepo.save(new Ville(ville));
		
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

}