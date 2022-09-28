package com.aos.matgar.Store;

import com.aos.matgar.Address.Address;
import com.aos.matgar.Product.Product;
import com.aos.matgar.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "STORE")
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="store")
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private Set<Address> addresses;


}
