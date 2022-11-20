package com.aos.matgar.Group_Rule;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aos.matgar.Group.Group;
import com.aos.matgar.Rule.Rule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Entity
@Data
@Table(name="Group_Rule")
public class Group_Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int group_rule_id;
	
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    Rule rule;

}

