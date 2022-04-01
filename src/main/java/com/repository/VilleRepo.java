package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.entity.Ville;

@Repository
public interface VilleRepo extends JpaRepository<Ville, String>, JpaSpecificationExecutor<Ville>{
	List<Ville> findAllByCodePostal(String codePostal);
    List<Ville> findAll();
}
