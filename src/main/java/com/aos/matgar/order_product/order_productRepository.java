package com.aos.matgar.order_product;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Order.Order;
import com.aos.matgar.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface order_productRepository extends
JpaRepository<order_product, String>{
	
	@Query(value = "SELECT * FROM order_product WHERE group_id = ?1" , nativeQuery = true)
	Optional<order_product> findById(String id);

	long countByOrder(Order order);

	long countByOrderAndProduct(Order order,Product product);
	order_product findFirstByOrderAndProduct(Order order,Product product);

	@Transactional
	void deleteByOrderAndProduct(Order order,Product product);

	@Transactional
	void deleteById(long id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM order_product WHERE group_id = ?1 " , nativeQuery = true)
	void deleteById( String id );

    Boolean existsById(Long id);

}
