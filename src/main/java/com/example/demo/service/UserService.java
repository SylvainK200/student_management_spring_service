package com.example.demo.service;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;

public interface UserService extends GenericService<User> {
    Role saveRole (Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    
}
