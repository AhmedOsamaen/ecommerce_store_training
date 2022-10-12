package com.aos.matgar.order_product;

import com.aos.matgar.Group.Group;
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
	
	public Optional<order_product> findById(String id) {

		return repoGroup.findById(id);
			
		}

	public Boolean isExsiting(Long id) {
		System.out.println(id);
		return repoGroup.existsById(id);

	}
}
