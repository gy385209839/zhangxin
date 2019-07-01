package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.dao.IrolesDao.findbyuserid"))
    })
    Users findByusername(String username);

    @Select("select * from users")
    List<Users> findall();

    @Insert("insert into users (username,password,email,phonenum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void saveuser(Users users);



    @Select("select * from users where id=#{id}")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.itheima.dao.IrolesDao.findbyuserid")) })
    Users findbyid(String id);

    @Select("select * from role where id not in( select roleId from users_role where userId=#{id})")
    List<Role> findOtherRole(String id);

    @Insert("insert into users_role(userid,roleid) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

   /* @Insert("insert into user_role(userId,roleId) value(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") Long userId, @Param("roleId") Long roleId);*/
}
