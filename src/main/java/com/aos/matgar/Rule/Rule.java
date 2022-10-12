package com.aos.matgar.Rule;

import java.util.Set;

import javax.persistence.*;

import com.aos.matgar.Group_Rule.Group_Rule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Target;

@Entity
@Data
@Table(name = "MATGAR_Rule")
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private long id;

	@Column(name = "description")
	private String description;


	@OneToMany(targetEntity = Group_Rule.class ,mappedBy = "rule",cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Group_Rule> group_Rules;
	
}
