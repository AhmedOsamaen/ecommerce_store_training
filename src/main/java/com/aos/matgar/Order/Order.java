package com.aos.matgar.Order;

import com.aos.matgar.Address.Address;
import com.aos.matgar.Product.Product;
import com.aos.matgar.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "MATGAR_ORDER")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long id;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="arrival_date")
    private Date arrival_date;

    @Column(name = "delivery_method")
    private String deliveryMethod;

    @Column(name = "total_cost")
    private String totalCost;

    @Column(name = "shipping_cost")
    private String shippingCost;

    @Column(name = "discount")
    private String discount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


    @Column(name = "stage")
    private Stage stage;

}
