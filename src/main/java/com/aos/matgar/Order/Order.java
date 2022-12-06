package com.aos.matgar.Order;

import com.aos.matgar.Address.Address;
import com.aos.matgar.Payment.Payment;
import com.aos.matgar.User.User;
import com.aos.matgar.order_product.order_product;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "MATGAR_ORDER")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long id;

    @OneToMany(mappedBy = "order")
	List<order_product> order_products;
	
   
    @OneToOne(targetEntity = Address.class,cascade = CascadeType.MERGE )
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
    private Address address;

    @ManyToOne()
//    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    
    @Column(name="create_date")
    private Date createDate;

    @Column(name="arrival_date")
    private Date arrivalDate;

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

    @OneToOne(targetEntity = Payment.class,cascade = CascadeType.MERGE )
    @JoinColumn(name = "Payment_id",referencedColumnName = "Payment_id")
    private Payment payment;

    @Column(name = "stage")
    private Stage stage;

}
