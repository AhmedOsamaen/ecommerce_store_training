package com.aos.matgar.Rule;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

@RestController

public class ControllerRule {

	@Autowired
	private ServiceRule serviceRule;
	
	@RequestMapping("getAllRules")
	public List<Rule> getAllRules() throws JsonMappingException, JsonProcessingException {
		 return serviceRule.findAll();
	}
	
	@RequestMapping("Rule/getRuleById/{id}")
	public Optional<Rule> getRuleById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceRule.findById(id);
		 
	}
	
	@RequestMapping("Rule/addRule")
	public Rule addRule(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Rule lib = mapper.readValue(pBody, Rule.class);
		System.out.println(lib.getDescription());
		 return serviceRule.addRule(lib);
		 
	}
	
	@RequestMapping("Rule/updateRule")
	public Rule updateRule(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Rule lib = mapper.readValue(pBody, Rule.class);
		 return serviceRule.updateRule(lib);
		 
	}
	
	@RequestMapping("Rule/deleteRuleByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceRule.deleteByID(id);
		 
	}
}
