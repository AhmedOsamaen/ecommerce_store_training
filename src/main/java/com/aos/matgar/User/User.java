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
    @MapsId("id")
    @JoinColumn(name = "id")
    Group group;
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

   
}
