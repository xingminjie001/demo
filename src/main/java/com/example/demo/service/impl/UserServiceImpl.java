package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author xingminjie
 * @email xingminjie@trip.com
 * @date 2021/03/16 15:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(int id){
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByName(String name){

        return userMapper.getUserByName(name);
    }
    @Override
    public Integer insertUser(User user){
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        System.out.println(user);
        System.out.println("-----------------");
        System.out.println(userMapper);
        return userMapper.insertUser(user);
    }
}
