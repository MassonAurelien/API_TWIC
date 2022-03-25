package com.ville;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepo extends JpaRepository<Ville, String>, JpaSpecificationExecutor<Ville>{
	List<Ville> findAllByCodePostal(String CodePostal);
    List<Ville> findAll();
}
