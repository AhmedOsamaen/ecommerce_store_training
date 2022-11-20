package com.aos.matgar.Rule;

import java.util.Optional;
import java.util.Set;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

	@Autowired
	private RuleRepository repoRule;
	
	public List<Rule> findAll() {
		return repoRule.findAll();
		
	}

	protected Rule addRule(Rule rule) {

		return repoRule.save(rule);
			
		}
	
	protected void deleteByID(String id) {

		repoRule.deleteById(id);
		return ;
			
		}
	
	public Optional<Rule> findById(String id) {

		
		return repoRule.findById(id);
			
		}

	public Boolean isExsiting(Long id) {

		return repoRule.existsById(id);

	}
	
}
