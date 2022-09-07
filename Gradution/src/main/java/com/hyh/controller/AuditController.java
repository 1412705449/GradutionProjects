package com.hyh.controller;

import com.hyh.entity.Chapter;
import com.hyh.entity.Classify;
import com.hyh.entity.Store;
import com.hyh.service.AuditService;
import com.hyh.service.ChapterService;
import com.hyh.service.ClassifyService;
import com.hyh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Controller
public class AuditController {
    // 这里的是application.properties中配置的地址
    @Value("${uploadpic.path}")
    private String uploadPicPath;
    @Autowired
    AuditService auditService;
    @Autowired
    ClassifyService classifyService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private ChapterService chapterService;

    /*上传审核小说*/
    @RequestMapping(value = "/audit/addScore", method = {RequestMethod.GET,RequestMethod.POST})
    public String addScore(@RequestParam("cover") MultipartFile cover, Model model, String title, String typename, String author, String intro) throws Exception {
        Classify classify = classifyService.findId(typename);
        Double score = 0.0;
        String filename = storePic(cover);
        String newtime = Long.toString(new Date().getTime());
        auditService.addaudit(classify.getTypename(),title,filename,author,intro,score,newtime,0);
        return "admin/writeXSOk";
    }
    private String storePic(MultipartFile cover) throws Exception {
        String filename = StringUtils.cleanPath(cover.getOriginalFilename());
        try {
            try (InputStream inputStream = cover.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadPicPath+"\\"+filename), // 这里指定了下载的位置
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new Exception("失败！" + filename, e);
        }
        return filename;
    }
    /*上传审核小说章节*/
    @GetMapping("/audit/updateScore")
    public String updateScore(String title,String chap,String content){
        Store store = storeService.findTitle(title);
        Chapter chapter = chapterService.findNewChapter(store.getId());
        String create_time = Long.toString(new Date().getTime());
        if(chapter==null){
            content = content.replaceAll("\r\n", "<br>");
            content = content.replaceAll(" ", "&nbsp");
            auditService.addauditChap(1,store.getId(),chap,content,create_time,1);
            return "admin/updateXSOk";
        }
        auditService.addauditChap(store.getId(),chapter.getOrder()+1,chap,content,create_time,1);
        return "admin/updateXSOk";
    }
}
