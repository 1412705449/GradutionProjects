package com.hyh.service.admin.impl;

import com.hyh.entity.admin.aUser;
import com.hyh.mapping.admin.AUserMapping;
import com.hyh.service.admin.aUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class aMysqlUserService implements aUserService {
    @Autowired
    private AUserMapping aUserMapping;
    @Override
    public aUser find(String username, String password) {
        return aUserMapping.find(username,password);
    }

    @Override
    public void addUser(String username, String password, String create_time) {
        aUserMapping.addUser(username,password,create_time);
    }

    @Override
    public void delUser(Integer id) {
        aUserMapping.delUser(id);
    }

    @Override
    public List<aUser> findAll() {
        return aUserMapping.findAll();
    }

    @Override
    public aUser findName(String name) {
        return aUserMapping.findName(name);
    }
}
