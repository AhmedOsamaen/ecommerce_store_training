package com.aos.matgar.Store;

import com.aos.matgar.Address.Address;
import com.aos.matgar.Product.Product;
import com.aos.matgar.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity

@Table(name = "STORE")
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="store" ,cascade = CascadeType.ALL)
    private Set<Product> products;

    @ManyToOne()
//    @JsonIgnore
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private Set<Address> addresses;

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
