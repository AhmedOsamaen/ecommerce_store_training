package com.aos.matgar.Group_Rule;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Group.GroupService;
import com.aos.matgar.Rule.Rule;
import com.aos.matgar.Rule.RuleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class Group_RuleController {

	@Autowired
	private Group_RuleService group_ruleService;

	@RequestMapping("getAllGroup_Rules")
	public List<Group_Rule> getAllGroup_Rules() {
		 return group_ruleService.findAll();
	}
	
	@RequestMapping("getgroup_ruleById/{id}")
	public Optional<Group_Rule> getgroup_ruleById(@PathVariable String id) {
		 return group_ruleService.findById(id);
	}

	@RequestMapping("addGroup_Rule")
	public Group_Rule addGroup_Rule(@RequestBody Group_Rule group_rule)  {

		 return group_ruleService.addGroup_Rule(group_rule);
		 
	}
	
	@RequestMapping("deleteGroup_RuleByID/{id}")
	public void deleteGroup_RuleByID(@PathVariable String id) {
		System.out.println("asdadasd :- " + id);
		group_ruleService.deleteGroup_RuleByID(id);
		 
	}
}
