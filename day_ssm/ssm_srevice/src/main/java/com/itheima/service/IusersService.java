package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IusersService extends UserDetailsService {
    List<Users> findall();

    void saveuser(Users users);

     Users findById(String id);

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String[] ids);
}
