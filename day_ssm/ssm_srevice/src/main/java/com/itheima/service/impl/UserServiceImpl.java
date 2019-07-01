package com.itheima.service.impl;

import com.itheima.dao.IUserDao;

import com.itheima.domain.Role;
import com.itheima.domain.Users;
import com.itheima.service.IusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/30 15:36
 * @Version: 1.0
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements IusersService {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userInfo = iUserDao.findByusername(username);
        if(null!=userInfo&&userInfo.getStatus()==1){
            User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));

            return user;
        }
        return null;

    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return list;
    }

    @Override
    public List<Users> findall() {
        List<Users> list= iUserDao.findall();
        return list;
    }

    @Override
    public void saveuser(Users users) {
        /*users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));*/
        iUserDao.saveuser(users);
    }

    @Override
    public Users findById(String id) {
        return iUserDao.findbyid(id);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return iUserDao.findOtherRole(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            iUserDao.addRoleToUser(userId,id);
        }
    }


}
