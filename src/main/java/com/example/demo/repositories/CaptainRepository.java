package com.example.demo.repositories;
import com.example.demo.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    // Find captains with a rating above a threshold
    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);

    // Find captain by license number
    Captain findByLicenseNumber(String licenseNumber);
}
