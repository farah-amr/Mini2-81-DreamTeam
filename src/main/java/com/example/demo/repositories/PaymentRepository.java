package com.example.demo.repositories;


import com.example.demo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByAmountGreaterThan(double amount);
    List<Payment> findByTripId(Long tripId);
}

