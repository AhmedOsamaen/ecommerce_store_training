package com.aos.matgar.Payment;

import com.aos.matgar.Group.GroupService;
import com.aos.matgar.User.User;
import com.aos.matgar.User.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@CrossOrigin("*")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService serviceUser;

    @RequestMapping("addUserPayment")
    public Set<Payment> addUserPayment(@RequestBody Payment payment) {
        System.out.println("addUserPayments" );
        User user = serviceUser.findById("13").get();
        System.out.println("addUserPayments:- "+ user.getId() );
        paymentService.addPayment(payment);
        return user.getPayment_arr();
    }

    @RequestMapping("deletePaymentByID/{id}")
    public void deleteByID(@PathVariable String id) throws JsonProcessingException {

        paymentService.deleteByID(Long.valueOf(id ));
    }

    @RequestMapping("getPaymentById/{id}")
    public Optional<Payment> addUserPayment(@PathVariable String id) {

        return paymentService.findById(id);
    }

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




