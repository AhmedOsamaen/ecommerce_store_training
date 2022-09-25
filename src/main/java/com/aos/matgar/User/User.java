package com.aos.matgar.User;

import com.aos.matgar.Product.Product;
import com.aos.matgar.Store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "MATGAR_USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Store> stores;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
