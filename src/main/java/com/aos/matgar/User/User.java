package com.aos.matgar.User;

import com.aos.matgar.Address.Address;
import com.aos.matgar.Group.Group;
import com.aos.matgar.Order.Order;
import com.aos.matgar.Payment.Payment;
import com.aos.matgar.Product.Product;
import com.aos.matgar.Store.Store;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "MATGAR_USER")
@EqualsAndHashCode(exclude = {"payment_arr","addresses","orders"})
@ToString(exclude = {"payment_arr","addresses","orders"})
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Group group;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Store> stores;


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Address> addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Order> orders;


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Payment> payment_arr;

    String name;
	int age;
	String email;
	String username;
	String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

//    public Set<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(Set<Address> addresses) {
//        this.addresses = addresses;
//    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
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
