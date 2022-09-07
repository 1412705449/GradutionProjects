package com.hyh.service.impl;

import com.hyh.entity.Classify;
import com.hyh.mapping.ClassifyMapping;
import com.hyh.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlClassifyService implements ClassifyService {
    @Autowired
    ClassifyMapping classifyMapping;
    @Override
    public List<Classify> findAll() {
        return classifyMapping.findAll();
    }

    @Override
    public Classify findId(String id) {
        return classifyMapping.findId(id);
    }
}
