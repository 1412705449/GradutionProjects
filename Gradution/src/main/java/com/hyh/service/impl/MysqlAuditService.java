package com.hyh.service.impl;

import com.hyh.entity.Audit;
import com.hyh.mapping.admin.AuditMapping;
import com.hyh.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MysqlAuditService implements AuditService {
    @Autowired
    private AuditMapping auditMapping;

    @Override
    public List<Audit> findAll() {
        return auditMapping.findAll();
    }

    @Override
    public Audit findAudit(String id) {
        return auditMapping.findAudit(id);
    }

    @Override
    public void addaudit(  String typename, String title, String img, String author,  String intro, double score, String newtime,int storeChap){
       auditMapping.addaudit(typename,title,img,author,intro,score,newtime,storeChap);
    }

    @Override
    public void addauditChap(int order,int store_id,  String chap, String content, String create_time,int storeChap) {
        auditMapping.addauditChap(order,store_id,chap,content,create_time,storeChap);
    }

    @Override
    public void updateaudit1(Integer id) {
        auditMapping.updateUser1(id);
    }

    @Override
    public void updateaudit2(Integer id) {
        auditMapping.updateUser2(id);
    }
}
