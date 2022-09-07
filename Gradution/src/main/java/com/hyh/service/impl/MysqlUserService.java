package com.hyh.service.impl;

import com.hyh.entity.User;
import com.hyh.mapping.UserMapping;
import com.hyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlUserService  implements UserService {

    @Autowired
    private UserMapping userMapping;

    @Override
    public User findId(String id) {
        return userMapping.findId(id);
    }

    @Override
    public User findName(String name) {
        return userMapping.findName(name);
    }

    @Override
    public Integer SurePassword(String name, String password) {
        return userMapping.SurePassword(name,password);
    }

    @Override
    public void addUser(String name, String password, String create_time) {
    userMapping.addUser(name,password,create_time);
    }

    @Override
    public List<User> findAll() {
        return userMapping.findAll();
    }

    //修改用户  正常
    @Override
    public void updateUser1(Integer id) {
            userMapping.updateUser1(id);
    }
    //修改用户  冻结
    @Override
    public void updateUser0(Integer id) {
        userMapping.updateUser0(id);
    }
}
