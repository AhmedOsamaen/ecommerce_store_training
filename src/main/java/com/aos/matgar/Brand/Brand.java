package com.aos.matgar.Brand;

import com.aos.matgar.Product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@Table(name = "BRAND")
public class Brand {
    @Id
    @GeneratedValue
    @Column(name = "brand_id")
    String id;
    String name;
    String shortDescription;
    @ManyToMany
    @JoinTable(
            name = "brands_products",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> products;

}
