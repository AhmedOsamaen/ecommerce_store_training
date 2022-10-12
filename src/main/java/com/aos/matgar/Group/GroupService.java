package com.aos.matgar.Group;

import java.util.Optional;
import java.util.Set;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repoGroup;
	
	public List<Group> findAll() {
		return repoGroup.findAll();
		
	}

	public Group addGroup(Group group) {
		System.out.println("group" + group);
		return repoGroup.save(group);
			
		}
	
	protected void deleteByID(String id) {

		repoGroup.deleteById(id);
		return ;
			
		}
	
	public Optional<Group> findById(String id) {

		return repoGroup.findById(id);
			
		}

	public Boolean isExsiting(Long id) {
		System.out.println(id);
		return repoGroup.existsById(id);

	}
}
