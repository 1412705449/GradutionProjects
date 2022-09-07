package com.hyh.service.impl;

import com.hyh.entity.Recmomend;
import com.hyh.entity.Store;
import com.hyh.mapping.RecmomendMapping;
import com.hyh.service.RecmomendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlRecmomendService implements RecmomendService {
    @Autowired
    private RecmomendMapping recmomendMapping;
    @Override
    public List<Store> findALlRecmomend() {
        return recmomendMapping.findAllRecmomend();
    }

//    @Override
//    public void del(Integer id) {
//        recmomendMapping.del(id);
//    }

//    @Override
//    public void add(Integer id, String create_time) {
//            recmomendMapping.add(id,create_time);
//    }

    @Override
    public Recmomend findId(Integer id) {
        return recmomendMapping.findId(id);
    }

    @Override
    public List<Store> findNvRecmomend() {
        return recmomendMapping.findNvRecmomend();
    }
}
