package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface ITravellerDao {
    @Select("select * from member where id=#{id}")
    Member findBymemberId(String id) ;
}
