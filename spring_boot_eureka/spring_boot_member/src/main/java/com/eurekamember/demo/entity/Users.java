package com.eurekamember.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;


/**
 * @Author: xurongguang
 * @Date: 2019/12/20 0020
 */
//@Document(indexName = "tiktok_store",type = "user")
@Data
public class Users {
    @Id
    private String id;
    private String name;
    private Integer age;
}