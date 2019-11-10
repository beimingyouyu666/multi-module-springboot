package com.yangk.multimodulespringboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangk.multimodulespringboot.dao.UserDao;
import com.yangk.multimodulespringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author yangkun
 * @Date 2019/11/3
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("hello")
    public String hello() {
        return "hello world!";
    }

    @RequestMapping("insert")
    public String insert(String name,String password) {
        User user = userDao.insertUser(name, password);
        return JSONObject.toJSONString(user);
    }

    @RequestMapping("list")
    public String list() {
        List<User> users = userDao.listUser();
        return JSONObject.toJSONString(users);
    }

}
