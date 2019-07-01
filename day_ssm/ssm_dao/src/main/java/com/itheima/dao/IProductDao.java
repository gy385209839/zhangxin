package com.itheima.dao;

import com.itheima.domain.Member;
import com.itheima.domain.Product;
import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    List<Product> findAll(int page, int pageSize);



    @Insert("insert into product(productNum,productName,cityName,departureTime," +
            "productPrice,productDesc,productStatus) values(#{productNum}," +
            "#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);




    @Select("select * from product where id=#{id}")
    Product findById(String id) ;

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findByOrdersId(String id) ;


}
