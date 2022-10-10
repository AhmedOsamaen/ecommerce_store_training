package com.aos.matgar.Group;

import java.util.Optional;
import java.util.Set;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGroup {

	@Autowired
	private RepoGroup repoGroup;
	
	public List<Group> findAll() {
		return repoGroup.findAll();
		
	}

	protected Group addGroup(Group Group) {

		return repoGroup.save(Group);
			
		}
	
	protected void deleteByID(String id) {

		repoGroup.deleteById(id);
		return ;
			
		}
	
	protected Optional<Group> findById(String id) {

		
		return repoGroup.findById(id);
			
		}
	
	protected Group updateGroup(Group Group) {

		
		return repoGroup.save(Group);
			
		}
	
}
