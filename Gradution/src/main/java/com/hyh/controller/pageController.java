package com.hyh.controller;

import com.hyh.entity.Chapter;
import com.hyh.entity.Message;
import com.hyh.entity.Store;
import com.hyh.service.ChapterService;
import com.hyh.service.MessageService;
import com.hyh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class pageController {

    @Autowired
    private StoreService storeService;

    @Autowired
    MessageService messageService;
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/page/id={id}")
    public String index(@PathVariable String id, Model model){

        Store id1 = storeService.findId(id);
        id1.setNewtime(new SimpleDateFormat("YYYY-MM-dd").format(new Date(Long.parseLong(id1.getNewtime()))));
        List<Chapter> aNew = chapterService.findNew(id1.getId());
        Chapter last = chapterService.findLast(Integer.parseInt(id));
        if(last==null){
            last=new Chapter();
            last.setId(-1);
        }

        List<Message> messageList = messageService.findAll(id);
        for(int i=0;i<messageList.size();i++){
            messageList.get(i).setNewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(messageList.get(i).getNewtime()))));
        }

        model.addAttribute("messageList",messageList);
        model.addAttribute("lastChap",last);
        model.addAttribute("chaplist",aNew);
        model.addAttribute("siteurl","https://www.biqudao.com");
        model.addAttribute("id",id);
        model.addAttribute("store",id1);
        return "page";
    }

}
