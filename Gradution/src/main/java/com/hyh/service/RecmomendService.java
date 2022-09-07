package com.hyh.service;

import com.hyh.entity.Recmomend;
import com.hyh.entity.Store;

import java.util.List;

public interface RecmomendService {
    public List<Store> findALlRecmomend();
    //删除推荐
  //  public void del(Integer id);
    //添加推荐
   // public void add(Integer id,String create_time);
    //查找推荐小说
    public Recmomend findId(Integer id);
    

    public List<Store> findNvRecmomend();

}
