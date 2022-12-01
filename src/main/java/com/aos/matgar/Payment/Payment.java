package com.aos.matgar.Payment;

import com.aos.matgar.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MATGAR_PAYMENT")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "Payment_id")
    private long id;

//    @ManyToOne()
////    @JsonIgnore
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id" )
//    @JsonBackReference
//    private User user;

    @Column(name="Card_Name")
    private String cardName;
    @Column(name="Card_Number")
    private String cardNumber;
    @Column(name="Card_Holder_Name")
    private String cardHolderName;
    @Column(name="Expire_Date")
    private String expireDate;
    @Column(name="Last_three_number_back")
    private String last_three_number_back;
}
