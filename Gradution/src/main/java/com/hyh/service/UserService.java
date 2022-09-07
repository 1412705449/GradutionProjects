package com.hyh.service;

import com.hyh.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //ID查找对象
    public User findId(String id);
    //用户名查找对象
    public User findName(String name);
    //核对密码
    public Integer SurePassword(String name,String password);
    //添加用户
    public void addUser(String name,String password,String create_time);
   //查询所有用户
    public List<User> findAll();
    //修改用户  正常
    public void updateUser1(Integer id);
    //修改用户  冻结
    public void updateUser0(Integer id);

}
