package com.example.demo.services;
import com.example.demo.models.Payment;
import com.example.demo.repositories.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public Payment addPayment(Payment payment){
        Payment saved = paymentRepository.save(payment);
        return saved;
    }
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();

    }
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found: " + id));
    }
    public Payment updatePayment(Long id, Payment p) {
        Payment existing = getPaymentById(id);
        existing.setAmount(p.getAmount());
        existing.setPaymentMethod(p.getPaymentMethod());
        existing.setPaymentStatus(p.getPaymentStatus());
        existing.setTrip(p.getTrip());
        return paymentRepository.save(existing);
    }
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    public List<Payment> findPaymentsByTripId(Long tripId){
        return paymentRepository.findByTripId(tripId);
    }
    public List<Payment> findByAmountThreshold(Double threshold){
        return paymentRepository.findByAmountGreaterThan(threshold);
    }
}

