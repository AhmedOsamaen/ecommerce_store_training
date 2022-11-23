package com.aos.matgar.order_product;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Order.Order;
import com.aos.matgar.Product.Product;
import com.aos.matgar.Rule.RuleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class order_productController {

	@Autowired
	private order_productService serviceorder_product;

	@Autowired
	private RuleService ruleService;

	ObjectMapper mapper = new ObjectMapper();
	@RequestMapping("getAllorder_products")
	public List<order_product> getAllorder_products() throws JsonMappingException, JsonProcessingException {
		
		

		 return serviceorder_product.findAll();
		 
	}
	
	@RequestMapping("getorder_productById/{id}")
	public Optional<order_product> getorder_productById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceorder_product.findById(id);
		 
	}
	
	@PostMapping("addorder_product")
	public order_product addorder_product(@RequestBody order_product pBody) {
		 return serviceorder_product.addGroup(pBody);
		 
	}

	@RequestMapping("deleteorder_productByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceorder_product.deleteByID(id);
		 
	}

	@PostMapping("deleteOrderProduct")
	public ResponseEntity deleteByID(@RequestBody Map<String,Object> body) {
		Order order = mapper.convertValue(body.get("order"),Order.class);
		Product product = mapper.convertValue(body.get("product"),Product.class);
		try {
			serviceorder_product.deleteByOrderProduct(order,product);
			return  new ResponseEntity("Deleted Successfully",HttpStatus.OK) ;
		}catch (Exception e){
			return  new ResponseEntity("DeleteFailed",HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}

	@PostMapping("getCartCount")
	public ResponseEntity getProductsCount(@RequestBody Order body){
		return new ResponseEntity( serviceorder_product.getCartCount(body), HttpStatus.OK);
	}

	@PostMapping("getCartCountByOrderAndProduct")
	public ResponseEntity getProductsCountByOrderAndProduct(@RequestBody Map<String,Object> body){
		Order order = mapper.convertValue(body.get("order"),Order.class);
		Product product = mapper.convertValue(body.get("product"),Product.class);
		return new ResponseEntity( serviceorder_product.getCartCountByOrderAndProduct(order,product), HttpStatus.OK);
	}
}
