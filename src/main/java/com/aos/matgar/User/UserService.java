package com.aos.matgar.User;

import java.util.Optional;
import java.util.Set;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository repoUser;
	
	public List<User> findAll() {
		return repoUser.findAll();
		
	}

	protected User addUser(User User) {

		return repoUser.save(User);
		}
	@Transactional
	public ResponseEntity deleteByID(String id) {
		try {
			repoUser.deleteById(id);
			return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity("Failure in Address Delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	public Optional<User> findById(String id) {

		
		return repoUser.findById(id);
			
		}
	
}
