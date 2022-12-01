package com.aos.matgar.Payment;

import com.aos.matgar.Group.GroupService;
import com.aos.matgar.User.User;
import com.aos.matgar.User.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("addPayment")
    public ResponseEntity addPayment(@RequestBody Payment payment){
        System.out.println(payment.getCardName());

        try {
            paymentService.addPayment(payment);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Payment Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @RequestMapping("getAllPayments")
    public List<Payment> getAllPayments(){
            return paymentService.getAllPayments();
    }

}




