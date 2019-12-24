package com.eurekamember.demo.member;

import com.eurekamember.demo.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: xurongguang
 * @Date: 2019/12/10 0010
 */
@Mapper
public interface MemberMapper {
    @Insert("insert into users values(null,#{name},#{age});")
    public int addUser(@Param("name") String name, @Param("age") Integer age);
    @Select("select * from users")
    List<Users> selectAll();
}
