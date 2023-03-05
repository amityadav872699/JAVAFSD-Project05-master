package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Customer;
import com.demo.models.User;

import java.util.List;

public interface IUserService {

    public Customer insertProductinExistingUserInDB(Customer customer, Long userid, Long productid) throws ResourceNotFound;
    public User insertUserInDB(User user);
    public void updateUserInDB(User user,Long userId) throws ResourceNotFound;
    public List<User> getAllUsers();

}
