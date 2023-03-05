package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Admin;

public interface IAdminService {

    public Admin insertAdminInDB(Admin admin);
    public void updateAdminInDB(Admin admin,Long adminId) throws ResourceNotFound;

}
