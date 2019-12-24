package com.example.demo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xurongguang
 * @Date: 2019/12/12 0012
 */
@FeignClient("user-member")
public interface ClientDemo {
    @RequestMapping(value="/addUser", method= RequestMethod.GET)
    String transmitInformation(@RequestParam("name") String name, @RequestParam("age") Integer age);
}
