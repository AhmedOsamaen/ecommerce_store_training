package com.aos.matgar.Group;

import java.util.ArrayList;
import java.util.List;

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

import lombok.Data;

@Entity
@Table(name="MATGAR_Group") 
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private long id;
	
	String name;

	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id" , referencedColumnName = "group_id")
	private List<User> users;
	
	@OneToMany(mappedBy = "group")
	List<Group_Rule> group_Rules;
	
	public Group() {
		
	}

	public Group(String name) {
		super();
		this.name = name;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
