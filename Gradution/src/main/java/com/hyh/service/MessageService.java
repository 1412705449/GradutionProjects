package com.hyh.service;

import com.hyh.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    //根据id查询
    public Message findById(int id);
    //查询所有类别
    public List<Message> findAll(String store_id);
    public void addMessage(int user_id,int store_id, String username, String content, String newtime);

    //删除
    public void delMessage(int id);
}
