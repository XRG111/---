package com.eurekamember.demo.controller;

import com.eurekamember.demo.entity.Users;
import com.eurekamember.demo.member.MemberMapper;
import com.eurekamember.demo.order.OrderMapper;
import com.eurekamember.demo.remote.ClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xurongguang
 * @Date: 2019/12/10 0010
 */
@Controller
public class MybatisController {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Resource
    private ClientDemo cd;

    /**
     * 添加会员数据
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/addUser")
    public @ResponseBody
    String addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return memberMapper.addUser(name, age) > 0 ? "success" : "fail";
    }

    /**
     * 添加订单数据
     *
     * @param number
     * @return
     */
    @RequestMapping("/inserOrder")
    public  @ResponseBody String inserOrder(String number) {
        return orderMapper.inserOrder(number) > 0 ? "success" : "fail";
    }

    @RequestMapping("/client")
    public  @ResponseBody String clientDemo() {
        List<Users> user = memberMapper.selectAll();
        return cd.transmitInformation(user);
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Users> users = memberMapper.selectAll();
        model.addAttribute("users", users);
        return "list";
    }
    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

}
