package com.hyh.service.impl;

import com.hyh.entity.Author;
import com.hyh.mapping.AuthorMapping;
import com.hyh.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlAuthorService implements AuthorService {

    @Autowired
    private AuthorMapping authorMapping;

    @Override
    public Author findId(String id) {
        return authorMapping.findId(id);
    }

    @Override
    public Author findName(String name) {
        return authorMapping.findName(name);
    }

    @Override
    public Integer SurePassword(String name, String password) {
        return authorMapping.SurePassword(name,password);
    }

    @Override
    public void addAuthor(String name, String password, String create_time) {
        authorMapping.addAuthor(name,password,create_time);
    }

    @Override
    public List<Author> findAllAuthor() {
        return authorMapping.findAllAuthor();
    }

    //修改用户  正常
    @Override
    public void updateAuthor1(Integer id) {
        authorMapping.updateAuthor1(id);
    }
    //修改用户  冻结
    @Override
    public void updateAuthor0(Integer id) {
        authorMapping.updateAuthor0(id);
    }
}
