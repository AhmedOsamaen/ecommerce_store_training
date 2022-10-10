package com.aos.matgar.Rule;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RepoRule extends 
JpaRepository<Rule, String>{
	
	@Query(value = "SELECT * FROM MATGAR_Rule WHERE rule_id = ?1" , nativeQuery = true)
	Optional<Rule> findById(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MATGAR_Rule WHERE rule_id = ?1 " , nativeQuery = true)
	void deleteById( String id );
}
