package com.aos.matgar.Product;

import com.aos.matgar.Store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;


    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private Set<Store> stores;

    public Product() {
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
}
