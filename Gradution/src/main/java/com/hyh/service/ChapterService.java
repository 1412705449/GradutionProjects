package com.hyh.service;

import com.hyh.entity.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {
    //查找最新章节
    public List<Chapter> findNew(int id);
    //查询所有章节
    public List<Chapter> findAll(int id);
    //查询指定章节
    public Chapter findId(int id,int cid);
    //查找最早发布
    public  Chapter findLast(int id);
    //查找order
    public Integer findOrder(String id);
    //查找相邻记录
    public List<Chapter> findNear(String id,Integer start,Integer end);
    //查找更更新的一章
    public Chapter findNewChapter(int id);
    //添加小说章节
   public void addChapter(int order,int store_id,String chap, String content,String create_time);

}
