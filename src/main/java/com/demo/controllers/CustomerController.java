package com.demo.controllers;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Customer;
import com.demo.services.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/insertcustomer/{id}")
    public Customer insertCustomer(@RequestBody Customer newUser, @PathVariable("id") Long id) throws ResourceNotFound {
        return customerService.insertCustomerInDB(newUser, id);
    }

    @GetMapping("/getallcustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/getcustomer/{userid}")
    public Customer getCustomer(@PathVariable("userid") Long customerId) throws ResourceNotFound {
        return customerService.getCustomerInDB(customerId);
    }

    @DeleteMapping("/deletecustomer/{userid}")
    public void deleteCustomer(@PathVariable("userid") Long customerId) {
        customerService.deleteCustomerInDB(customerId);
    }

    @PutMapping("/updatecustomerbyid/{userid}")
    public void updateCustomer(@PathVariable("userid") Long userId, @RequestBody Customer user) throws ResourceNotFound {
        customerService.updateCustomerInDB(user, userId);
    }

    @PutMapping("/addcustomerproducts/{custid}/{prodid}")
    public void updateProductInCustomer(@PathVariable("custid") Long userId, @PathVariable("prodid") Long prodid, @RequestBody Customer user) throws ResourceNotFound {
        customerService.insertProductinExistingCustomerInDB(user, userId, prodid);
    }

}
