package com.itheima.mapper;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from ceshi where id=#{id}")
    User getUserById(Integer id);
    @Select("select count(*)  from user")
    Integer getCount();

}
