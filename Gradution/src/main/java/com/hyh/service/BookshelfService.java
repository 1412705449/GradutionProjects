package com.hyh.service;

import com.hyh.entity.Bookshelf;
import com.hyh.entity.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookshelfService {
    //查询用户书架所有内容
    public List<Store> findALl(Integer uid);
    //添加到书架
    public void addBook(Integer uid,Integer sid,String newtime);
    //查询关系是否存在
    public Integer findN(Integer uid,Integer sid);
    //查询书架是否存在
    public Bookshelf findById(Integer user_id);

}
