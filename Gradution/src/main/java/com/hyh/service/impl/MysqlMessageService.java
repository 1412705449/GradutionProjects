package com.hyh.service.impl;

import com.hyh.entity.Message;
import com.hyh.mapping.MessageMapping;
import com.hyh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlMessageService implements MessageService {
    @Autowired
    private MessageMapping messageMapping;

    @Override
    public Message findById(int id) {
        return messageMapping.findById(id);
    }

    @Override
    public List<Message> findAll(String store_id) {
        return messageMapping.findAll(store_id);
    }

    @Override
    public void addMessage(int user_id, int store_id, String username, String content, String newtime) {
        messageMapping.addMessage(user_id,store_id,username,content,newtime);
    }

    @Override
    public void delMessage(int id) {
        messageMapping.delMessage(id);
    }
}
