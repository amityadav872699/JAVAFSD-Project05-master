package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Admin;
import com.demo.repository.AdminRepository;
import com.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private CustomerRepository custRepo;

    @Override
    public Admin insertAdminInDB(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public void updateAdminInDB(Admin admin, Long adminId) throws ResourceNotFound {
        Admin existingAdmin = adminRepo.findById(adminId).get();
        if(admin != null) {
            // Update existing Admin with Password.
            existingAdmin.setPwd(admin.getPwd());
            adminRepo.save(existingAdmin);
        } else {
            throw new ResourceNotFound("Customer not found");
        }
    }



}
