package com.aos.matgar.Rule;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.aos.matgar.Group_Rule.Group_Rule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import javax.persistence.Id;

@Entity
@Data
@Table(name = "MATGAR_Rule")
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "rule")
	Set<Group_Rule> group_Rules;
	
	public Rule(){
		
	}
	public Rule(String description) {
		super();
		this.setDescription(description);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
