package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Customer;
import com.demo.models.Product;
import com.demo.models.PurchasedProduct;
import com.demo.models.User;
import com.demo.repository.CustomerRepository;
import com.demo.repository.ProductRepository;
import com.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements  IUserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    CustomerRepository customerRepo;
    Float total = (float) 0;

    @Override
    public Customer insertProductinExistingUserInDB(Customer customer, Long userid, Long product_id) throws ResourceNotFound {
        Set<PurchasedProduct> list;
        User newUser = userRepo.findById(userid).get();
        if((newUser != null) && productRepo.existsById(product_id)) {
            total = (float) 0;
            Product prod = productRepo.findById(product_id).get();
            PurchasedProduct n1 = new PurchasedProduct();
            Customer new1 = new Customer();
            // Setting up Product Details
            n1.setPrice(prod.getPrice());
            n1.setOrigin(prod.getOrigin());
            n1.setCategory(prod.getCategory());
            n1.setCompany(prod.getCompany());
            n1.setSize(prod.getSize());
            n1.setTag(prod.getTag());
            list = new1.getList();
            list.add(n1);
            // Setting up Customer Details
            new1.setCustomerName(newUser.getUserName());
            new1.setEmail(newUser.getUserEmail());
            new1.setContact(newUser.getUserContact());
            total += n1.getPrice();
            new1.setDate(customer.getDate());
            new1.setTotalPrice(total);
            new1.setList(list);
            return customerRepo.save(new1);
        } else throw new ResourceNotFound("Not found");
    }

    @Override
    public User insertUserInDB(User user) {
        return userRepo.save(user);
    }

    @Override
    public void updateUserInDB(User user, Long userId) throws ResourceNotFound {
        User existingUser = userRepo.findById(userId).get();
        if(user != null) {
            // Update existing Singed up User Details with new Details.
            existingUser.setUserName(user.getUserName());
            existingUser.setUserContact(user.getUserContact());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserPwd(user.getUserPwd());
            userRepo.save(existingUser);
        } else {
            throw new ResourceNotFound("Not able to do Update");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
