package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Ville;
import com.model.VilleModel;

@Repository
public interface VilleRepo extends JpaRepository<Ville, String>, JpaSpecificationExecutor<Ville>{
	List<Ville> findAllByCodePostal(String codePostal);
    List<Ville> findAll();
    Ville getByCodeINSEE(String codeINSEE);
    @Transactional
    void deleteByCodeINSEE(String codeINSEE);
	void saveAndFlush(VilleModel ville);
}
