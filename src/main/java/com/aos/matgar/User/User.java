package com.aos.matgar.User;

import com.aos.matgar.Address.Address;
import com.aos.matgar.Group.Group;
import com.aos.matgar.Order.Order;
import com.aos.matgar.Product.Product;
import com.aos.matgar.Store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "MATGAR_USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    // Saleh 
    @ManyToOne
   
    @JoinColumn(name = "group_id")
    private Group group;
    // END
    
    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Store> stores;

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Order> orders;

    String name;
	int age;
	String email;
	String username;
	String password;
	
    public User() {
    }

	public User(String name, int age, String email, String username, String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.username = username;
		this.password = password;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
   
}
