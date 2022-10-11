package com.aos.matgar.Address;

import com.aos.matgar.Store.Store;
import com.aos.matgar.User.User;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "building_number")
    private String buildingNum;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "town")
    private String town;

    @Column(name = "full_address")
    private String fullAdrs;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne()
//    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne()
//    @JsonIgnore
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;

}
