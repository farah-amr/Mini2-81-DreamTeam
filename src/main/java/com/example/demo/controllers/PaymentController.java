package com.example.demo.controllers;
import com.example.demo.models.Payment;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @GetMapping("/allPayments")
    public List<Payment> getAllPayments(){
        return  paymentService.getAllPayments();
    }


    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment){
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment with ID " + id + " has been deleted.");
    }

    @GetMapping("/findByTripId")
    public List<Payment> findPaymentsByTripId(@RequestParam Long tripId){
        return paymentService.findPaymentsByTripId(tripId);
    }

    @GetMapping("/findByAmountThreshold")
    public List<Payment> findPaymentsWithAmountGreaterThan(@RequestParam Double threshold){
        return paymentService.findByAmountThreshold(threshold);
    }
}

