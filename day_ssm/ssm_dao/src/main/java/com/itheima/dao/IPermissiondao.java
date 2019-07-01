package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissiondao {
    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission p);

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findByRoleId(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findOtherpermission(String id);

    @Select("select * from permission where id=#{id}")
    Permission finbyid(String id);

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id);

    @Delete("delete from permission where id=#{id}")
    void deleteById(String id);
}
