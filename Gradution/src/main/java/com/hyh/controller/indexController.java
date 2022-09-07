package com.hyh.controller;

import com.hyh.entity.Store;
import com.hyh.service.RecmomendService;
import com.hyh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 首页控制器
 */

@Controller
public class indexController {

    //小说
    @Autowired
    private StoreService storeService;
    //推荐小说
    @Autowired
    private RecmomendService recmomendService;
    @RequestMapping("/")
    public String index(Model model){
        List<Store> nvRecmomend = recmomendService.findNvRecmomend();
        List<Store> aLlStore = recmomendService.findALlRecmomend();
        List<Store> hotStore = storeService.findHotStore();
        List<Store> newStore = storeService.findNewStore();
        model.addAttribute("siteurl","https://www.biqudao.com");
        model.addAttribute("recmomendList",aLlStore);
        model.addAttribute("hotlist",hotStore);
        for(int i=0;i<newStore.size();i++){
            newStore.get(i).setNewtime(new SimpleDateFormat("MM-dd HH:mm").format(new Date(Long.parseLong(newStore.get(i).getNewtime()))));
    }
     model.addAttribute("nvRecmomend",nvRecmomend);
        model.addAttribute("newlist",newStore);

        return "index";
    }
}
