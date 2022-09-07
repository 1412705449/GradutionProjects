package com.hyh.controller;

import com.hyh.entity.Classify;
import com.hyh.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ClassifyController {
    @Autowired
    ClassifyService classifyService;
    //查询所有类别
    @GetMapping("/author/classifyAll")
    public String classifyAll( Model model){
        List<Classify> allclassify = classifyService.findAll();
        model.addAttribute("allclassify",allclassify);
        return "authorWrite";
    }
    //跳转到上传章节
    @GetMapping("/author/authorUpdate")
    public String authorUpdate( Model model){
        return "authorUpdate";
    }
}
