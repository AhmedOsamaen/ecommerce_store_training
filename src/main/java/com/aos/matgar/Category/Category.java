package com.aos.matgar.Category;

import com.aos.matgar.Product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name = "MATGAR_CATEGORY")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    long id;
    String name;
    String shortDescription;
    String longDescription;

    @ManyToMany
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "categories_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> products;
//    int level;
//    Category parentCategory;
}
