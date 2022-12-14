package com.hyh.service;

import com.hyh.entity.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小说接口类
 */

public interface StoreService {
    //找到所有小说
    public List<Store> findAllStore();
    //找到热门小说
    public List<Store> findHotStore();
    //找到最新小说
    public List<Store> findNewStore();
    //查找指定小说
    public Store findId(String id);
    //查找指定类型小说
    public List<Store> findTypeNmae(String typename,Integer curr);
    //查找指定类型指定小说
    public List<Store> findTypeStore(String typename ,String title);
    //查找指定名称小说
    public List<Store> findName(String title);
    //查询指定分类小说数量
    public Integer findSum(String typename);

    //查询指定数量小说
    public List<Store> findnumberStore(Integer start);
    //查询所有小说数量
    public Integer findNums();
    //添加小说
    public void addStore(int id,String typename,String title, String img, String author, String intro, double score,  String newtime,String recmomend);
    //查找指定名称小说
    public Store findTitle(String title);

    //修改评分
    public void updateScore(double score,int id);

    /*通过id查找*/
    public Store findById(@Param("id")int id);
}
