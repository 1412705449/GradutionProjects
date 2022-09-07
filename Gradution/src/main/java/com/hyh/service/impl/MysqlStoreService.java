package com.hyh.service.impl;

import com.hyh.entity.Store;
import com.hyh.mapping.StoreMapping;
import com.hyh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小说接口mysql实现类
 */
@Service
public class MysqlStoreService implements StoreService {

    @Autowired
    private StoreMapping storeMapping;
    @Override
    public List<Store> findAllStore() {
        return storeMapping.findAllStore();
    }

    @Override
    public List<Store> findHotStore() {
        return storeMapping.findHotStore();
    }

    @Override
    public List<Store> findNewStore() {
        return storeMapping.findNewStore();
    }

    @Override
    public Store findId(String id) {
        return storeMapping.findId(id);
    }

    @Override
    public List<Store> findTypeNmae(String typename,Integer curr) {
        return storeMapping.findTypeNmae(typename,curr);
    }

    @Override
    public List<Store> findTypeStore(String typename, String title) {
        return storeMapping.findTypeStore(typename,title);
    }

    @Override
    public List<Store> findName(String title) {
        return storeMapping.findName(title);
    }

    @Override
    public Integer findSum(String typename) {
        return storeMapping.findSum(typename);
    }

    @Override
    public List<Store> findnumberStore(Integer start) {
        return storeMapping.findnumberStore(start);
    }

    @Override
    public Integer findNums() {
        return storeMapping.findNums();
    }

    @Override
    public void addStore(int id,String typename, String title, String img, String author, String intro, double score, String newtime,String recmomend) {
        storeMapping.addStore(id,typename,title,img,author,intro,score,newtime,recmomend);
    }

    @Override
    public Store findTitle(String title) {
        return storeMapping.findTitle(title);
    }

    @Override
    public void updateScore(double score,int id) {
        storeMapping.updateScore(score,id);
    }

    @Override
    public Store findById(int id) {
        return storeMapping.findById(id);
    }


}
