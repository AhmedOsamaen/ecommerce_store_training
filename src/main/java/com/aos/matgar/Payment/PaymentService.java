package com.aos.matgar.Payment;

import com.aos.matgar.Rule.Rule;
import com.aos.matgar.User.User;
import com.aos.matgar.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Payment> findById(String id) {


        return repoPayment.findById(id);

    }
    @Transactional
    public void deleteByID(long id) {

        repoPayment.deleteById(id);
        return ;

    }
}
