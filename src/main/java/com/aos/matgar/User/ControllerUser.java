package com.aos.matgar.User;
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
public class ControllerUser {

	@Autowired
	private ServiceUser serviceUser;
	
	@RequestMapping("getAllUsers")
	public List<User> getAllUsers() throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceUser.findAll();
		 
	}
	
	@RequestMapping("getUserById/{id}")
	public Optional<User> getUserById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceUser.findById(id);
		 
	}
	
	@RequestMapping("addUser")
	public User addUser(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		User lib = mapper.readValue(pBody, User.class);
		System.out.println(lib.getName());
		 return serviceUser.addUser(lib);
		 
	}
	
	@RequestMapping("updateUser")
	public User updateUser(@RequestBody String pBody) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		User lib = mapper.readValue(pBody, User.class);
		 return serviceUser.updateUser(lib);
		 
	}
	
	@RequestMapping("deleteUserByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceUser.deleteByID(id);
		 
	}
}
