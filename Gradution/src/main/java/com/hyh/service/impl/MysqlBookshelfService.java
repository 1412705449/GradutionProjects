package com.hyh.service.impl;

import com.hyh.entity.Bookshelf;
import com.hyh.entity.Store;
import com.hyh.mapping.BookshelfMapping;
import com.hyh.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlBookshelfService implements BookshelfService {
    @Autowired
    private BookshelfMapping bookshelfMapping;
    @Override
    //查询用户书架所有内容
    public List<Store> findALl(Integer uid) {
        return bookshelfMapping.findALl(uid);
    }

    @Override
    //添加到书架
    public void addBook(Integer uid, Integer sid,String newtime) {
        bookshelfMapping.addBook(uid,sid,newtime);
    }

    @Override
    //查询关系是否存在
    public Integer findN(Integer uid, Integer sid) {
        return bookshelfMapping.findN(uid,sid);
    }

    @Override
    public Bookshelf findById(Integer user_id) {
        return bookshelfMapping.findById(user_id);
    }
}
