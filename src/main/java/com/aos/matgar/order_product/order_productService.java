package com.aos.matgar.order_product;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Order.Order;
import com.aos.matgar.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class order_productService {

	@Autowired
	private order_productRepository repoGroup;
	
	public List<order_product> findAll() {
		return repoGroup.findAll();
		
	}

	public order_product addGroup(order_product group) {
		System.out.println("group" + group);
		return repoGroup.save(group);
			
		}
	
	protected void deleteByID(String id) {
		repoGroup.deleteById(id);
		return ;
		}

	protected void deleteByOrderProduct(Order order, Product product) {
		try {
			order_product order_product = repoGroup.findFirstByOrderAndProduct(order,product);
			repoGroup.deleteById(order_product.getId());
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	public Optional<order_product> findById(String id) {

		return repoGroup.findById(id);
			
		}

	public Boolean isExsiting(Long id) {
		System.out.println(id);
		return repoGroup.existsById(id);

	}

	public long getCartCount(Order order){
		return repoGroup.countByOrder(order);
	}

	public long getCartCountByOrderAndProduct(Order order, Product product){
		return repoGroup.countByOrderAndProduct(order,product);
	}
}
