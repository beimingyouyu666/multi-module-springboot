package com.yangk.multimodulespringboot.dao;

import com.yangk.multimodulespringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author yangkun
 * @Date 2019/11/10
 * @Version 1.0
 */
@Repository
public class UserDao {

    private ConcurrentHashMap<String,User> userMap = new ConcurrentHashMap();

    public User insertUser(String name,String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userMap.put(name,user);
        return user;
    }

    public List<User> listUser() {
        List<User> result = userMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        return result;
    }

}
