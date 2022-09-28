package com.aos.matgar.order_product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.aos.matgar.Order.Order;
import com.aos.matgar.Product.Product;
@Entity
@Table(name = "order_products")
public class order_product {

	@Id
    @GeneratedValue
    @Column(name = "O_P_id")
    private long id;

	@ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    Order order;
	 
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    int Quantity;
    
   
}
