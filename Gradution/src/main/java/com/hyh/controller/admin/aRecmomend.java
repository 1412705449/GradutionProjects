package com.hyh.controller.admin;

import com.hyh.entity.Store;
import com.hyh.service.RecmomendService;
import com.hyh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 后台小说推荐控制器
 */
@Controller
public class aRecmomend {
    @Autowired
    private RecmomendService recmomendService;
    @Autowired
    private StoreService storeService;
    /**
     * 小说推荐页面
     */
    @GetMapping("admin/recmomend")
    public String remomon(Model model){
        List<Store> aLlStore = recmomendService.findALlRecmomend();

        List<Store> nvRecmomend = recmomendService.findNvRecmomend();
        for(int i=0;i<aLlStore.size();i++){
            aLlStore.get(i).setNewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(aLlStore.get(i).getNewtime()))));
        }
        for(int i=0;i<nvRecmomend.size();i++){
            nvRecmomend.get(i).setNewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(nvRecmomend.get(i).getNewtime()))));
        }
        model.addAttribute("nvRecmomend",nvRecmomend);
        model.addAttribute("recmolist",aLlStore);
        return "admin/recmomend";
    }
    /**
     * 添加小说页面
     */
    @GetMapping("admin/recmomendadd")
    public String addPage(Model model){
        List<Store> allStore = storeService.findAllStore();
        model.addAttribute("storelist",allStore);
        return "admin/recmomendadd";
    }
}
