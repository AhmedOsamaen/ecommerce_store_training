package com.aos.matgar.Group_Rule;

import com.aos.matgar.Group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface Group_RuleRepository extends
JpaRepository<Group_Rule, String>{
	
	@Query(value = "SELECT * FROM Group_Rule WHERE group_rule_id = ?1" , nativeQuery = true)
	Optional<Group_Rule> findById(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Group_Rule WHERE group_rule_id = ?1 " , nativeQuery = true)
	void deleteById( String id );
}
