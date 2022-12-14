package com.hyh.mapping;

import com.hyh.entity.Chapter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterMapping {
    //查询最新章节
    @Select("SELECT * from chapter where store_id=#{id} ORDER BY `order` desc limit 5")
    public List<Chapter> findNewChap(@Param("id")int id);
    //查询所有章节
    @Select("SELECT * from chapter where store_id =#{id} order by `order`")
    public List<Chapter> findAll(@Param("id")int id);
    //查询指定章节
    @Select("SELECT * from chapter where store_id =#{id} and id=#{cid}")
    public Chapter findChapt(@Param("id")int id,@Param("cid")int cid);
    //查找最早的一章
    @Select("SELECT * from chapter where store_id=#{id} ORDER BY `order`  limit 1")
    public Chapter findLastChat(@Param("id")int id);
    //根据id查询指定order
    @Select("select `order` from chapter where id=#{id}")
    public Integer findOrder(@Param("id") String id);
    //查询相邻数据
    @Select("SELECT * from chapter WHERE store_id=#{id} and `order`=#{start} or store_id=#{id} and `order`=#{end}")
    public List<Chapter> findNear(@Param("id")String id,@Param("start")int start,@Param("end")int end);

    //查找更更新的一章
    @Select("SELECT * from chapter where store_id=#{id} ORDER BY `order` desc limit 1")
    public Chapter findNewChapter(@Param("id")int id);
    //添加小说章节
    @Insert("insert into `chapter`(`order`,`store_id`,`chap`,`content`,`create_time`)VALUES(#{order},#{store_id},#{chap},#{content},#{create_time}) ")
    public void addChapter(@Param("order") int order,@Param("store_id") int store_id,@Param("chap") String chap,@Param("content") String content,@Param("create_time") String create_time);

}

