package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Customer;
import com.demo.models.Product;
import com.demo.models.PurchasedProduct;
import com.demo.repository.CustomerRepository;
import com.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private ProductRepository productRepo;
    float total = 0;

    @Override
    public Customer insertCustomerInDB(Customer customer,Long product_id) throws ResourceNotFound {
        total = customer.getTotalPrice();
        Set<PurchasedProduct> list = new HashSet<>();
        if(productRepo.existsById(product_id)) {
            Product prod = productRepo.findById(product_id).get();
            PurchasedProduct n1 = new PurchasedProduct();
            n1.setPrice(prod.getPrice());
            n1.setOrigin(prod.getOrigin());
            n1.setCategory(prod.getCategory());
            n1.setCompany(prod.getCompany());
            n1.setSize(prod.getSize());
            n1.setTag(prod.getTag());
            total += prod.getPrice();
            list.add(n1);
            customer.setTotalPrice(total);
            customer.setList(list);
            return customerRepo.save(customer);
        } else throw new ResourceNotFound("Stock Unavailable");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void updateCustomerInDB(Customer customer, Long customerId) throws ResourceNotFound {

        Customer existingUser = customerRepo.findById(customerId).get();
        if(customer != null) {
            // Update existing Product Details with new Details.
            existingUser.setCustomerName(customer.getCustomerName());
            existingUser.setContact(customer.getContact());
            existingUser.setDate(customer.getDate());
            existingUser.setEmail(customer.getEmail());
            customerRepo.save(existingUser);
        } else {
            throw new ResourceNotFound("Customer not found");
        }
    }

    @Override
    public void deleteCustomerInDB(Long customerId) {
        customerRepo.deleteById(customerId);
    }

    @Override
    public Customer getCustomerInDB(Long customerId) throws ResourceNotFound {
        return customerRepo.findById(customerId).get();
    }

    @Override
    public Customer insertProductinExistingCustomerInDB(Customer customer, Long customer_id, Long product_id) throws ResourceNotFound {

        Set<PurchasedProduct> list;
        Customer new1 = customerRepo.findById(customer_id).get();
        if((new1 != null) && productRepo.existsById(product_id)) {
            total = new1.getTotalPrice();
            Product prod = productRepo.findById(product_id).get();
            PurchasedProduct n1 = new PurchasedProduct();
            customerRepo.deleteById(customer_id);
            n1.setPrice(prod.getPrice());
            n1.setOrigin(prod.getOrigin());
            n1.setCategory(prod.getCategory());
            n1.setCompany(prod.getCompany());
            n1.setSize(prod.getSize());
            n1.setTag(prod.getTag());
            list = new1.getList();
            list.add(n1);
            total += prod.getPrice();
            new1.setDate(customer.getDate());
            new1.setTotalPrice(total);
            new1.setList(list);
            return customerRepo.save(new1);
        } else throw new ResourceNotFound("Not found");
    }

    //Custom
    @Override
    public List<Customer> findByDate(String date) {
        return customerRepo.findByDate(date);
    }

    @Override
    public List<Customer> findByCustomerName(String customerName) {
        return customerRepo.findByCustomerName(customerName);
    }
}
