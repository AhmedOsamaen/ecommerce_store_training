package com.aos.matgar.User;

import java.util.Optional;
import java.util.Set;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {

	@Autowired
	private RepoUser repoUser;
	
	public List<User> findAll() {
		return repoUser.findAll();
		
	}

	protected User addUser(User User) {

		return repoUser.save(User);
			
		}
	
	protected void deleteByID(String id) {

		repoUser.deleteById(id);
		return ;
			
		}
	
	protected Optional<User> findById(String id) {

		
		return repoUser.findById(id);
			
		}
	
	protected User updateUser(User User) {

		
		return repoUser.save(User);
			
		}
	
}
