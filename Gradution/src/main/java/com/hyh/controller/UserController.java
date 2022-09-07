package com.hyh.controller;

import com.hyh.entity.Bookshelf;
import com.hyh.entity.User;
import com.hyh.service.BookshelfService;
import com.hyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookshelfService bookshelfService;
    //登录或注册页面
    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public String index(@RequestParam(value = "bookId",defaultValue = "")String bookId,@RequestParam(value = "books",defaultValue = "-1")String books, Model model){
        model.addAttribute("bookId",bookId);
        return "login";
    }
    //登录或者注册请求
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(value = "bookId",defaultValue = "-1")String bookId, @RequestParam("loginName")String loginName, @RequestParam("password")String password,HttpSession session){
        User name = userService.findName(loginName);

        if(name!=null){
            if(name.getJudgment()==1){
                Integer integer = userService.SurePassword(loginName, password);
                if(integer>0){
                    session.setAttribute("username",name.getUsername());
                    return "{\"code\":200,\"uid\":"+name.getId()+"}";
                }else{
                    return "{\"code\":401}";
                }
            }else{
                return "{\"code\":250}";
            }
        }else{
            userService.addUser(loginName,password,Long.toString(new Date().getTime()));
        }
        if("-1".equals(bookId)){
           User name1 = userService.findName(loginName);
            Bookshelf bookshelf = bookshelfService.findById(name1.getId());
            if(bookshelf!=null){
                bookshelfService.addBook(name1.getId(),Integer.parseInt(bookId),Long.toString(new Date().getTime()));
                return "{\"code\":200,\"uid\":"+name1.getId()+"}";
            }else {
                return "{\"code\":200,\"uid\":"+name1.getId()+"}";
            }
        }else{
            return "{\"code\":200}";
        }
    }
}
