package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Customer;

import java.util.List;

public interface ICustomerService {

    public Customer insertCustomerInDB(Customer customer, Long product_id) throws ResourceNotFound;
    public List<Customer> getAllCustomers();
    public void updateCustomerInDB(Customer customer,Long customerId) throws ResourceNotFound;
    public void deleteCustomerInDB(Long customerId);
    public Customer getCustomerInDB(Long customerId) throws ResourceNotFound;
    public Customer insertProductinExistingCustomerInDB(Customer customer, Long customer_id, Long product_id) throws ResourceNotFound;

    // Custom
    public List<Customer> findByDate(String date);
    public List<Customer> findByCustomerName(String customerName);
}
