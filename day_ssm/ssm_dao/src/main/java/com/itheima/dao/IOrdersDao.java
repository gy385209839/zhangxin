package com.itheima.dao;

import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productid", property = "product", one = @One(select =
                    "com.itheima.dao.IProductDao.findById"))
    })
    List<Orders> findAll(int page, int pageSize);

    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productid", property = "product", one = @One(select =
                    "com.itheima.dao.IProductDao.findById")),
            @Result(column = "id", property = "travellers", many = @Many(select =
                    "com.itheima.dao.IProductDao.findByOrdersId")),
            @Result(column = "memberId", property = "member", one = @One(select =
                    "com.itheima.dao.ITravellerDao.findBymemberId"))
    })
    Orders findbyid(String id);

    @Delete("delete from orders where id=#{id}")
    void deleteorderbyid(String id);
}
