package com.eurekamember.demo.order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xurongguang
 * @Date: 2019/12/10 0010
 */
@Mapper
public interface OrderMapper {
    @Insert("insert into order_number values(null,#{number});")
    int inserOrder(@Param("number") String number);
}
