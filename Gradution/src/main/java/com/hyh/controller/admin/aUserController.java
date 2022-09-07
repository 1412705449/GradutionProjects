package com.hyh.controller.admin;

import com.hyh.entity.User;
import com.hyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class aUserController {

    @Autowired
    private UserService userService;


    /**
     * 查询所有用户
     */
    @GetMapping("admin/userlist")
    public String userlist(Model model){
        List<User> all = userService.findAll();

        for(int i=0;i<all.size();i++){
            all.get(i).setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(all.get(i).getCreate_time()))));
        }

        model.addAttribute("userlist",all);
        return "admin/user";
    }
    /**
     * 修改用户
     */
    @PostMapping("/admin/userupd")
    @ResponseBody
    public String userupd(@RequestParam("id")String id){
        User user = userService.findId(id);
        if(user.getJudgment()==0){
            userService.updateUser1(Integer.parseInt(id));
        }else {
            userService.updateUser0(Integer.parseInt(id));
        }
        return "{\"code\":200}";
    }

}
