package com.eurekamember.demo.remote;

import com.eurekamember.demo.entity.MemberUser;
import com.eurekamember.demo.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: xurongguang
 * @Date: 2019/12/12 0012
 */
@FeignClient("user-order")
public interface ClientDemo {
    @RequestMapping(value="/v1/client", method= RequestMethod.POST)
    String transmitInformation(@RequestBody List<Users> user);
}
