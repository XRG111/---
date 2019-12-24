package com.example.demo.controller;


import com.example.demo.entity.MemberUser;
import com.example.demo.entity.Users;
import com.example.demo.remote.ClientDemo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xurongguang
 * @Date: 2019/12/12 0012
 */
@RestController
@RequestMapping("/v1")
public class DemoController {
    @Resource
    ClientDemo clientDemo;
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Map<Integer,Users> changeOrder (@RequestBody List<Users> user){
        Map<Integer,Users> map = new HashMap<>();
        int id=1;
        for (Users us : user) {
            map.put(id++,us);
        }
        return map;
    }

    @RequestMapping(value = "/toinsert/{name}/{age}", method = RequestMethod.GET)
    public String charu (@PathVariable("name") @Valid String name, @PathVariable("age") @Valid  Integer age){
        return clientDemo.transmitInformation(name,age);
    }
}



