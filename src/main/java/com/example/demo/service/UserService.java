package com.example.demo.service;

import com.example.demo.domain.User;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 15:01
 */

public interface UserService {

    User getUser(int id);

    Integer insertUser(User user);
}
