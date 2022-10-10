package com.aos.matgar.Group;
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
public class ControllerGroup {

	@Autowired
	private ServiceGroup serviceGroup;
	
	@RequestMapping("getAllGroups")
	public List<Group> getAllGroups() throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceGroup.findAll();
		 
	}
	
	@RequestMapping("getGroupById/{id}")
	public Optional<Group> getGroupById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceGroup.findById(id);
		 
	}
	
	@RequestMapping("addGroup")
	public Group addGroup(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Group lib = mapper.readValue(pBody, Group.class);
		System.out.println(lib.getName());
		 return serviceGroup.addGroup(lib);
		 
	}
	
	@RequestMapping("updateGroup")
	public Group updateGroup(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Group lib = mapper.readValue(pBody, Group.class);
		 return serviceGroup.updateGroup(lib);
		 
	}
	
	@RequestMapping("deleteGroupByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceGroup.deleteByID(id);
		 
	}
}
