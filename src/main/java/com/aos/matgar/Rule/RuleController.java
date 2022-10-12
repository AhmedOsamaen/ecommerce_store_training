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
public class RuleController {

	@Autowired
	private RuleService serviceRule;
	
	@RequestMapping("getAllRules")
	public List<Rule> getAllRules() throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceRule.findAll();
		 
	}
	
	@RequestMapping("getRuleById/{id}")
	public Optional<Rule> getRuleById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceRule.findById(id);
		 
	}
	
	@RequestMapping("addRule")
	public Rule addRule(@RequestBody Rule rule) {
		 return serviceRule.addRule(rule);
	}
	
	@RequestMapping("deleteRuleByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceRule.deleteByID(id);
		 
	}
}
