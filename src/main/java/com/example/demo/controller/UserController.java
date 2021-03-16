package com.example.demo.controller;

import com.example.demo.LearnTest;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingminjie
 * @email xingminjie@trip.com
 * @date 2021/03/16 15:00
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable int id){
        System.out.println(id);
        return userService.getUser(id);
    }

    @GetMapping("/add")
    public Integer createUser(User user){
        User newuser = new User();
        newuser.setName("李四12");
        newuser.setAge(12);
        newuser.setPassword("12345678");
        return userService.insertUser(newuser);
    }

    @PostMapping("/add")
    public String Bb(@RequestBody String param) throws JSONException, org.json.JSONException, JsonProcessingException {
        Map<String,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Integer xx = 0;
        Integer age;
        JSONObject json1 = new JSONObject(param);
        String name = (String) json1.get("name");
        String password = (String) json1.get("password");
        if("".equals((String)json1.get("age"))){
            age = 0;
        }else{
            age = Integer.parseInt((String)json1.get("age")) ;
        }
        if("".equals(name) || "".equals(password)){
            map.put("code", 3003);
            map.put("msg", "缺少必要的参数！");
            return mapper.writeValueAsString(map);
        }

        User sqlName = userService.getUserByName(name);
        System.out.println(sqlName);
        if(sqlName != null){
            map.put("code", 3002);
            map.put("msg", "用户名已存在");
            return mapper.writeValueAsString(map);
        }
//        Collection<u> list = [];
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);
        try {
            xx = userService.insertUser(user);
        } catch (Exception ee) {
             ee.printStackTrace();
        }
        if(xx==1){
            map.put("code", 200);
            map.put("msg", "成功");
        }else{
            map.put("code", 3001);
            map.put("msg", "添加失败!");
        }
        return mapper.writeValueAsString(map);
    }


//    @GetMapping("/test")
//    //创建一个方法public String getTest()
//    public String getTest() throws InterruptedException {
//        //通过new关键字配合构造方法LearnTest()完成实例化对象并取名test
//        LearnTest test = new LearnTest();
//        //输出通过对象名.方法名进行调用的方法add()的值
//        System.out.println(test.add());
//        //输出通过类名.方法名进行调用的方法del()的值
//        System.out.println(LearnTest.del());
//        //创建一个局部变量color：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁
//        String color = "red";
//        Thread.sleep(1000);
//        return color;
//    }
//    public int add(){
//        return 1+1;
//    }
//    public static int del(){
//        return 2+2;
//    }




}
