package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 15:00
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);

    }

    @PostMapping("/createUser")
    public Integer createUser(@RequestBody User user){
        return userService.insertUser(user);
    }

}
