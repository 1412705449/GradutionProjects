package com.hyh.mapping;

import com.hyh.entity.Classify;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyMapping {
    //查询所有类别
    @Select("SELECT * from classify")
    public List<Classify> findAll();

    //通过id查询
    @Select("SELECT * from classify where id=#{id}")
    public Classify findId(@Param("id")String id);
}
