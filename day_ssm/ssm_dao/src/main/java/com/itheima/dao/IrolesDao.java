package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IrolesDao {
    @Select("select * from role where id in (select roleid from users_role where userid=#{id})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class,
                    many = @Many(select = "com.itheima.dao.IPermissiondao.findByRoleId"))})
    List<Role> findbyuserid(String id);

    @Select("select * from role")
    List<Role> findall();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.IPermissiondao.findByRoleId"))
    })
    Role findbyid(String id);

    @Insert("insert into role_permission (permissionid,roleid) values (#{id},#{roleid})")
    void addPermissionToRole(@Param("roleid") String roleid,@Param("id") String id);
}
