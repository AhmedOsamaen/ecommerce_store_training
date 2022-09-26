package com.aos.matgar.User;

import com.aos.matgar.Address.Address;
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

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Store> stores;

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<Order> orders;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
