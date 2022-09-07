package com.hyh.service;

import com.hyh.entity.Classify;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassifyService {
    //查询所有类别
    public List<Classify> findAll();
    //通过id查询
    public Classify findId(String id);
}
