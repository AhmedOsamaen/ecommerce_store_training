package com.aos.matgar.User;
import java.util.Optional;
import java.util.Set;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Group.GroupService;
import com.aos.matgar.Group_Rule.Group_Rule;
import com.aos.matgar.Payment.Payment;
import com.aos.matgar.Payment.PaymentService;
import com.aos.matgar.Rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService serviceUser;

	@Autowired
	private GroupService serviceGroup;
	
	@RequestMapping("getAllUsers")
	public List<User> getAllUsers() throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceUser.findAll();
		 
	}

	@RequestMapping("getUserPayments/{id}")
	public Set<Payment> getUserPayments(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		return serviceUser.findById(id).get().getPayment_arr();
	}



	@RequestMapping("getUserById/{id}")
	public Optional<User> getUserById(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 return serviceUser.findById(id);
		 
	}
	
	@RequestMapping("addUser")
	public ResponseEntity addUser(@RequestBody User user){
		System.out.println(user.getName());

		try {
			serviceUser.addUser(user);
			return new ResponseEntity("Saved Successfully", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity("Failure in User Save", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//	@RequestMapping("addUserToGroup/{group_id}")
//	public String addUserToGroup(@RequestBody String pBody,@PathVariable String group_id) throws JsonMappingException, JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		User user = mapper.readValue(pBody, User.class);
//
//		if( serviceGroup.isExsiting(Long.valueOf(group_id)))
//			{
//				Group group = serviceGroup.findById(group_id).get();
//				group.getUsers().add(user);
////				user.setGroup(group);
//				System.out.println("asdasdasdadad");
//				serviceGroup.addGroup(group);
////				serviceUser.addUser(user);
//			}
//		else return "no group";
//		return "sucess add User ( "+
//				user.getName()
//				+ " ) To Group ( "+serviceGroup.findById(group_id).get().getName()+" )";
//	}

	@RequestMapping("deleteUserByID/{id}")
	public void deleteByID(@PathVariable String id) throws JsonMappingException, JsonProcessingException {
		
		
		 serviceUser.deleteByID(id);
		 
	}
}
