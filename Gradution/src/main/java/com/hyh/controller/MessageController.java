package com.hyh.controller;

import com.hyh.entity.Message;
import com.hyh.entity.User;
import com.hyh.service.MessageService;
import com.hyh.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class MessageController {
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @PostMapping("message/messageadd")
    @ResponseBody
    public String messageadd(@Param("store_id") int store_id,@Param("username")String username, @Param("content")String content){
        User name1 = userService.findName(username);
        if(name1!=null){
            User name = userService.findName(username);
            messageService.addMessage(name.getId(),store_id,username,content,Long.toString(new Date().getTime()));
            return "{\"code\":200}";
        }else {
            return "{\"code\":250}";
        }
    }
    // 删除
    @RequestMapping(value = "/message/delmessage",method = RequestMethod.POST)
    @ResponseBody
    public String delmessage(@Param("username")String username,int id){
        Message message = messageService.findById(id);
        if(message.getUsername().equals(username)){
            messageService.delMessage(id);
            return "{\"code\":200}";
        }else {
            return "{\"code\":400}";
        }
    }
}
