package com.aos.matgar.Group;
import java.util.Optional;

import com.aos.matgar.Group_Rule.Group_Rule;
import com.aos.matgar.Group_Rule.Group_RuleService;
import com.aos.matgar.Rule.RuleService;
import com.aos.matgar.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;

@RestController
public class GroupController {

	@Autowired
	private GroupService serviceGroup;

	@Autowired
	private Group_RuleService group_ruleService;

	@RequestMapping("getAllGroups")
	public List<Group> getAllGroups() throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceGroup.findAll();
		 
	}
	
	@RequestMapping("getGroupById/{id}")
	public Optional<Group> getGroupById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceGroup.findById(id);
		 
	}
	
	@RequestMapping("addGroup")
	public Group addGroup(@RequestBody Group group) throws JsonMappingException, JsonProcessingException {
		 return serviceGroup.addGroup(group);
	}

	@RequestMapping("deleteGroupByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		Group group = serviceGroup.findById(id).get();

		for ( User user : group.getUsers()) {
			user.setGroup(null);
		}
		List<Group_Rule> group_rules =group_ruleService.findAll();
		group_rules.size();
		for ( Group_Rule group_rule : group_rules) {
			if ( String.valueOf( group_rule.getGroup().getId() ).equals(id))
				group_ruleService.deleteGroup_RuleByID(String.valueOf(group_rule.getGroup_rule_id()));
		}
		 serviceGroup.deleteByID(id);
		 
	}
}
