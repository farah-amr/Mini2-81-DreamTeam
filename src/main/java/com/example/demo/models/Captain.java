package com.example.demo.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "captains")
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String licenseNumber;
    private Double avgRatingScore;
    @OneToMany(mappedBy = "captain")
    private List<Trip> trips; // 👈 this is the important part
    // Constructors
    public Captain() {}

    public Captain(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public Captain(Long id, String name, String licenseNumber, Double avgRatingScore) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    public Captain(String name, String licenseNumber, Double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Double getAvgRatingScore() {
        return avgRatingScore;
    }

    public void setAvgRatingScore(Double avgRatingScore) {
        this.avgRatingScore = avgRatingScore;
    }


}
