package com.itheima.service.impl;

import com.itheima.dao.IrolesDao;
import com.itheima.domain.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/4/1 14:23
 * @Version: 1.0
 */

@Service
public class IRoleServiceimpl implements IRoleService {
    @Autowired
    private IrolesDao irolesDao;
    @Override
    public List<Role> findAll() {
        return irolesDao.findall();
    }

    @Override
    public void save(Role role) {
        irolesDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return irolesDao.findbyid(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] Ids) {
        for (String id : Ids) {
            irolesDao.addPermissionToRole(roleId,id);
        }
    }
}
