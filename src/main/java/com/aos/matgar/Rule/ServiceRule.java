package com.aos.matgar.Rule;

import java.util.Optional;
import java.util.Set;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRule {

	@Autowired
	private RepoRule repoRule;
	
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
	
	protected Optional<Rule> findById(String id) {

		
		return repoRule.findById(id);
			
		}
	
	protected Rule updateRule(Rule rule) {

		
		return repoRule.save(rule);
			
		}
	
}
