package com.hyh.controller.admin;

import com.hyh.entity.Audit;
import com.hyh.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class aAuditController {
    @Autowired
    AuditService auditService;

    @GetMapping("admin/auditStoreAll")
    public String auditlist(Model model){
        List<Audit> all = auditService.findAll();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getNewtime()!=null){
                all.get(i).setNewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(all.get(i).getNewtime()))));
            }
        }
        model.addAttribute("auditlist",all);
        return "admin/auditStore";
    }

    @GetMapping("admin/auditStoreChapAll")
    public String auditStoreChapAll(Model model){
        List<Audit> all = auditService.findAll();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getCreate_time()!=null) {
                all.get(i).setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(all.get(i).getCreate_time()))));
            }
        }
        model.addAttribute("auditlist",all);
        return "admin/auditStoreChap";
    }

}
