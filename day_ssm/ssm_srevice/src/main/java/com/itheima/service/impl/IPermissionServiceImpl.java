package com.itheima.service.impl;

import com.itheima.dao.IPermissiondao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/31 18:34
 * @Version: 1.0
 */

@Service
public class IPermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissiondao iPermissiondao;
    @Override
    public List<Permission> findAll() {
        return iPermissiondao.findAll();
    }

    @Override
    public void save(Permission p) {
        iPermissiondao.save(p);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return iPermissiondao.findOtherpermission(id);
    }

    @Override
    public Permission findById(String id) {
        return iPermissiondao.finbyid(id);
    }

    @Override
    public void deleteById(String id) {
        iPermissiondao.deleteFromRole_Permission(id);
        iPermissiondao.deleteById(id);
    }
}
