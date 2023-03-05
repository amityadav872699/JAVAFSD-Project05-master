package com.demo.repository;

import com.demo.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom Queries
    public List<Customer> findByDate(String date);
    public List<Customer> findByCustomerName(String customerName);

}
