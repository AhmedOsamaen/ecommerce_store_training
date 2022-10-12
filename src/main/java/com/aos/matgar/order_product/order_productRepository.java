package com.aos.matgar.order_product;

import com.aos.matgar.Group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface order_productRepository extends
JpaRepository<order_product, String>{
	
	@Query(value = "SELECT * FROM order_product WHERE group_id = ?1" , nativeQuery = true)
	Optional<order_product> findById(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM order_product WHERE group_id = ?1 " , nativeQuery = true)
	void deleteById( String id );

    Boolean existsById(Long id);
}
