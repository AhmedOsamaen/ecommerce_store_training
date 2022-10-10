package com.aos.matgar.Group;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RepoGroup extends 
JpaRepository<Group, String>{
	
	@Query(value = "SELECT * FROM MATGAR_Group WHERE group_id = ?1" , nativeQuery = true)
	Optional<Group> findById(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MATGAR_Group WHERE group_id = ?1 " , nativeQuery = true)
	void deleteById( String id );
}
