package com.aos.matgar.Product;

import com.aos.matgar.Brand.Brand;
import com.aos.matgar.Category.Category;
import com.aos.matgar.Order.Order;

import com.aos.matgar.Store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;
    String name;
    @Column(name = "short_description")
    String shortDescription;//it will have more info for the product
    @Column(name = "long_description")
    String longDescription;//width,height,warranty,
    int price;
    int quantity;
    //will make discount a class but not a table
    int discount;// 20=20%
    int maximumDiscountValue;
    Date discountExpirationDate;
    /////////
    String images;//delimited by ;
    String model;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    Set<Order> orders;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    Set<Brand> brands= new HashSet<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    Set<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    Store store;
    //    Set<Review> reviews;
    Product(){};
}
