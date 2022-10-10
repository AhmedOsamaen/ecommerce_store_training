package com.aos.matgar.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RepoUser extends 
JpaRepository<User, String>{
	
	@Query(value = "SELECT * FROM MATGAR_User WHERE user_id = ?1" , nativeQuery = true)
	Optional<User> findById(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MATGAR_User WHERE user_id = ?1 " , nativeQuery = true)
	void deleteById( String id );
}
