package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission p);

    List<Permission> findOtherPermission(String id);

    Permission findById(String id);

    void deleteById(String id);
}
