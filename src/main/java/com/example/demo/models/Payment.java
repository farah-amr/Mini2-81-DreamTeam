package com.example.demo.models;
import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String paymentMethod; // e.g., "cash", "card"
    private Boolean paymentStatus; // true = paid, false = pending

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public Payment() {}

    public Payment(Double amount, String paymentMethod, Boolean paymentStatus, Trip trip) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.trip = trip;
    }

    public Payment(Long id, Double amount, String paymentMethod, Boolean paymentStatus, Trip trip) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.trip = trip;
    }

    // Getters and Setters
}
