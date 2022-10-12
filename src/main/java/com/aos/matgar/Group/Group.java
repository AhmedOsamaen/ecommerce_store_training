package com.aos.matgar.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.aos.matgar.Group_Rule.Group_Rule;
import com.aos.matgar.User.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Entity
@Data
@Table(name="MATGAR_Group") 
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private long id;
	
	String name;

	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id" , referencedColumnName = "group_id")
	@JsonManagedReference
	private List<User> users;
	
	@OneToMany(targetEntity = Group_Rule.class ,mappedBy = "group",cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Group_Rule> group_Rules;
	
	
}
