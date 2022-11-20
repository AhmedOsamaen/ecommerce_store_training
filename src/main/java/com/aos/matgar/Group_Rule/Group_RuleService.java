package com.aos.matgar.Group_Rule;

import com.aos.matgar.Group.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class Group_RuleService {

	@Autowired
	private Group_RuleRepository group_ruleRepository;
	
	public List<Group_Rule> findAll() {
		return group_ruleRepository.findAll();
		
	}
	protected Group_Rule addGroup_Rule(Group_Rule group_rule) {

		return group_ruleRepository.save(group_rule);
			
		}
	
	public void deleteGroup_RuleByID(String id) {

		group_ruleRepository.deleteById(id);
		return ;
			
		}
	
	protected Optional<Group_Rule> findById(String id) {

		
		return group_ruleRepository.findById(id);
			
		}
	
}
