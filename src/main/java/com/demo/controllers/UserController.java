package com.demo.controllers;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Customer;
import com.demo.models.PurchasedProduct;
import com.demo.models.User;
import com.demo.services.ICustomerService;
import com.demo.services.IPurchasedProductService;
import com.demo.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IPurchasedProductService prodService;
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/signup")
    public User insertUser(@RequestBody User newUser) {
        return userService.insertUserInDB(newUser);
    }

    @PostMapping("/insertproductinuser/{userid}/{prodid}")
    public Customer insertProductUserInDB(@RequestBody Customer newUser, @PathVariable("userid") Long userid, @PathVariable("prodid") Long prodid) throws ResourceNotFound {
        return userService.insertProductinExistingUserInDB(newUser, userid, prodid);
    }

    @PutMapping("/updateuserbyid/{userid}")
    public void updateUser(@PathVariable("userid") Long userId, @RequestBody User user) throws ResourceNotFound {
        userService.updateUserInDB(user, userId);
    }

    @PutMapping("/addmoreuserproducts/{custid}/{prodid}")
    public void updateProductInCustomer(@PathVariable("custid") Long userId, @PathVariable("prodid") Long prodid, @RequestBody Customer user) throws ResourceNotFound {
        customerService.insertProductinExistingCustomerInDB(user, userId, prodid);
    }

    @GetMapping("/getproducts/{userid}")
    public List<PurchasedProduct> getproducts(@PathVariable("userid") Long id)    {
        return prodService.findByCustomerId(id);
    }

}
