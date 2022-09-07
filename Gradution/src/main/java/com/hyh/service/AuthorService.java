package com.hyh.service;

import com.hyh.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    //ID查找对象
    public Author findId(String id);
    //用户名查找对象
    public Author findName(String name);
    //核对密码
    public Integer SurePassword(String name,String password);
    //添加用户
    public void addAuthor(String name,String password,String create_time);
   //查询所有用户
    public List<Author> findAllAuthor();
    //修改用户  正常
    public void updateAuthor1(Integer id);
    //修改用户  冻结
    public void updateAuthor0(Integer id);

}
