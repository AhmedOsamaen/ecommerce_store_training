package com.aos.matgar.order_product;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Rule.RuleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class order_productController {

	@Autowired
	private order_productService serviceorder_product;

	@Autowired
	private RuleService ruleService;

	@RequestMapping("getAllorder_products")
	public List<order_product> getAllorder_products() throws JsonMappingException, JsonProcessingException {
		
		

		 return serviceorder_product.findAll();
		 
	}
	
	@RequestMapping("getorder_productById/{id}")
	public Optional<order_product> getorder_productById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceorder_product.findById(id);
		 
	}
	
	@RequestMapping("addorder_product")
	public order_product addorder_product(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		order_product lib = mapper.readValue(pBody, order_product.class);

		 return serviceorder_product.addGroup(lib);
		 
	}

	@RequestMapping("deleteorder_productByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceorder_product.deleteByID(id);
		 
	}
}
