package com.aos.matgar.Payment;

import com.aos.matgar.Rule.Rule;
import com.aos.matgar.User.User;
import com.aos.matgar.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repoPayment;

    public Payment addPayment(Payment payment) {

        return repoPayment.save(payment);
    }
    public List<Payment>  getAllPayments() {

        return repoPayment.findAll();
    }
}
