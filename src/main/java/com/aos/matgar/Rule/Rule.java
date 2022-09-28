package com.aos.matgar.Rule;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.aos.matgar.Group_Rule.Group_Rule;

import javax.persistence.Id;

@Entity
@Table(name = "MATGAR_Rule")
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private long id;
	
	String discription;
	
	@OneToMany(mappedBy = "rule")
	Set<Group_Rule> group_Rules;
	
	public Rule(){
		
	}
	public Rule(String discription) {
		super();
		this.discription = discription;
	}
	
}
