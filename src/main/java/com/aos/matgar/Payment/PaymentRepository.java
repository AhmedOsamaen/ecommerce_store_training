package com.aos.matgar.Payment;

import com.aos.matgar.Rule.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PaymentRepository extends
        JpaRepository<Payment, String>{
    @Query(value = "SELECT * FROM MATGAR_PAYMENT WHERE Payment_id = ?1" , nativeQuery = true)
    Optional<Payment> findById(String id);
}
