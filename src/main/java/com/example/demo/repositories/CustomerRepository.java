package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customers whose email ends with a specific domain
    List<Customer> findByEmailEndingWith(String domain);

    // Find customers whose phone starts with a specific prefix
    List<Customer> findByPhoneNumberStartingWith(String prefix);
}
