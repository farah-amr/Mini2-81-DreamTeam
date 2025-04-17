package com.example.demo.services;
import com.example.demo.models.Trip;
import com.example.demo.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }
    // Get a specific trip by ID
//    public Trip getTripById(Long id) {
//        Optional<Trip> trip = tripRepository.findById(id);
//        return trip.orElse(null);
//    }
    // Update trip details
    public Trip updateTrip(Long id, Trip updatedTrip) {
        if (tripRepository.existsById(id)) {
            updatedTrip.setId(id);
            return tripRepository.save(updatedTrip);
        }
        return null; // Or handle exception
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime start, LocalDateTime end) {
        return tripRepository.findByTripDateBetween(start, end);
    }

    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}
