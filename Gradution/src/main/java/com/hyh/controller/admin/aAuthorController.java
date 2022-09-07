package com.hyh.controller.admin;

import com.hyh.entity.Author;
import com.hyh.service.AuthorService;
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
public class aAuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("admin/authorlist")
    public String authorlist(Model model){
        List<Author> all = authorService.findAllAuthor();
        for(int i=0;i<all.size();i++){
            all.get(i).setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(all.get(i).getCreate_time()))));
        }
        model.addAttribute("authorlist",all);
        return "admin/author";
    }

    @PostMapping("/admin/authorupd")
    @ResponseBody
    public String authorupd(@RequestParam("id")String id){
        Author author = authorService.findId(id);
        if(author.getJudgment()==0){
            authorService.updateAuthor1(Integer.parseInt(id));
        }else {
            authorService.updateAuthor0(Integer.parseInt(id));
        }
        return "{\"code\":200}";
    }


}
