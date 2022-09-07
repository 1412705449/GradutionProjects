package com.hyh.service;

import com.hyh.entity.Audit;

import java.util.List;

public interface AuditService {
    //查找所有审核小说
    public List<Audit> findAll();

    //查找指定审核小说
    public Audit findAudit(String id);

    //添加审核小说
    public void addaudit( String typename, String title, String img, String author,  String intro, double score, String newtime,int storeChap);
    //添加审核小说章节
    public void addauditChap( int order,int store_id, String chap, String content, String create_time,int storeChap);
    //修改用户  正常
    public void updateaudit1(Integer id);
    //修改用户  拒绝
    public void updateaudit2(Integer id);
}
