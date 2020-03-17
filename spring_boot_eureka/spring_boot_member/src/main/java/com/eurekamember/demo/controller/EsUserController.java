//package com.eurekamember.demo.controller;
//
//import com.eurekamember.demo.dao.UserDao;
//import com.eurekamember.demo.entity.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Optional;
//@Controller
//public class EsUserController {
//    @Autowired
//    private UserDao userDao;
//
//    /**
//     * 添加文档
//     * @param entity
//     * @return
//     */
//    @RequestMapping("/addEs")
//    public @ResponseBody
//    Users addUser(@RequestBody Users entity){
//         return userDao.save(entity);
//    }
//
//    /**
//     * 查询文档
//     * @param id
//     * @return
//     */
//    @GetMapping("/findById")
//    public @ResponseBody Optional<Users> findById(Integer id){
//        return userDao.findById(id);
//    }
//}
