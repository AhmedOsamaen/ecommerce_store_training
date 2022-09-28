package com.aos.matgar.Product;

import com.aos.matgar.Order.Order;
import com.aos.matgar.Store.Store;
import com.aos.matgar.order_product.order_product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;

    @OneToMany(mappedBy = "product")
	Set<order_product> order_products;
	
    @JsonIgnore
    @ManyToMany(mappedBy = "products" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
