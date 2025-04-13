package com.example.demo.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private Double tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Trip() {}

    public Trip(LocalDateTime tripDate, String origin, String destination, Double tripCost, Captain captain, Customer customer) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
    }

    public Trip(Long id, LocalDateTime tripDate, String origin, String destination, Double tripCost, Captain captain, Customer customer) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
    }

    // Getters and Setters
    // (You can auto-generate them with Alt+Insert)
}
