package com.hyh.controller;

import com.hyh.entity.Audit;
import com.hyh.entity.Author;
import com.hyh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@Controller
public class AuthorController {
    // 这里的是application.properties中配置的地址
    @Value("${uploadpic.path}")
    private String uploadPicPath;

    @Autowired
    private AuthorService authorService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AuditService auditService;
    //登录或注册页面
    @RequestMapping(value = "/author/login",method = RequestMethod.GET)
    public String index(@RequestParam(value = "bookId",defaultValue = "")String bookId,@RequestParam(value = "books",defaultValue = "-1")String books, Model model){
        model.addAttribute("bookId",bookId);
        return "authorLogin";
    }
    //登录或者注册请求
    @RequestMapping(value = "/author/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(value = "bookId",defaultValue = "-1")String bookId,@RequestParam("loginName")String loginName,@RequestParam("password")String password,Model model) {
        Author name = authorService.findName(loginName);
        if (name != null) {
            if (name.getJudgment() == 1) {
                Integer integer = authorService.SurePassword(loginName, password);
                if (integer > 0) {
                    return "{\"code\":200,\"uid\":" + name.getId() + "}";
                } else {
                    return "{\"code\":401}";
                }
            } else {
                return "{\"code\":250}";
            }
        } else {
            authorService.addAuthor(loginName, password, Long.toString(new Date().getTime()));
        }
        return null;
    }

    @GetMapping("/author/authorTwo")
    public String authorTwo(){
        return "/admin/authorTwo";
    }

    @GetMapping("author/welcom")
    public String welcom(Model model, HttpSession session){
        try {
            String s = InetAddress.getLocalHost().toString();
            Object hostName = InetAddress.getLocalHost().getHostName();
            String date = new Date().toString();

            model.addAttribute("serverIP",s);
            model.addAttribute("hostName",hostName);
            model.addAttribute("date",date);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "admin/welcom";
    }

    /*上传小说成功*/
    @RequestMapping(value = "/author/addScoreOK", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addScoreOK(@RequestParam("id") String id, Model model){
        Audit audit = auditService.findAudit(id);
        if(audit.getJudgment()==0){
            auditService.updateaudit1(audit.getId());
            storeService.addStore(audit.getId(),audit.getTypename(),audit.getTitle(),audit.getImg(),audit.getAuthor(),audit.getIntro(),audit.getScore(),audit.getNewtime(),"https://www.biqudao.com/bqge119305/");
            return "{\"code\":200}";
        }else {
            return "{\"code\":250}";
        }
    }
    /*上传小说失败*/
    @RequestMapping(value = "/author/addScoreNO", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addScoreNO(@RequestParam("id") String id, Model model){
        Audit audit = auditService.findAudit(id);
        if(audit.getJudgment()==0){
            auditService.updateaudit2(audit.getId());
            return "{\"code\":200}";
        }else {
            return "{\"code\":250}";
        }
    }
    /*上传小说章节*/
    @RequestMapping(value = "author/addScoreChapOK", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addScoreChapOK(@RequestParam("id") String id, Model model){
        Audit audit = auditService.findAudit(id);
        if(audit.getJudgment()==0){
            auditService.updateaudit1(audit.getId());
            chapterService.addChapter(audit.getOrder(),audit.getStore_id(),audit.getChap(),audit.getContent(),audit.getCreate_time());
            return "{\"code\":200}";
        }else {
            return "{\"code\":250}";
        }

    }
    /*上传小说章节*/
    @RequestMapping(value = "author/addScoreChapNO", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addScoreChapNO(@RequestParam("id") String id, Model model){
        Audit audit = auditService.findAudit(id);
        if(audit.getJudgment()==0){
            auditService.updateaudit2(audit.getId());
            return "{\"code\":200}";
        }else {
            return "{\"code\":250}";
        }
    }
}
