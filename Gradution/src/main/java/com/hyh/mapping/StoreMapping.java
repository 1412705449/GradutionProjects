package com.hyh.mapping;

import com.hyh.entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface StoreMapping {
    //查找所有小说
    @Select("select * from store order by id ")
    public List<Store> findAllStore();
    //查找最热小说
    @Select("SELECT * from store order by score desc limit 9")
    public List<Store> findHotStore();
    //查找最近更新小说
    @Select("select * from store order by newtime desc limit 20")
    public List<Store> findNewStore();
    //查找指定小说
    @Select("SELECT * from store where id=#{id}")
    public Store findId(@Param("id")String id);
    //查找指定类型小说
    @Select("select * from store where typename=#{typename} limit #{curr},10")
    public List<Store> findTypeNmae(@PathVariable("typename")String typename,@PathVariable("curr")Integer curr);
    //查找指定类型指定小说
    @Select("select * from store where typename=#{typename} and title=#{title}")
    public List<Store> findTypeStore(@PathVariable("typename")String typename ,@PathVariable("title")String title);
    //查找指定名称小说
    @Select("select * from store where author like concat(\"%\",#{title},\"%\") or title like  concat(\"%\",#{title},\"%\")")
    public List<Store> findName(@PathVariable("title")String title);
    //查询指定分类小说数量
    @Select("select count(*) as sum from store where typename=#{typename}")
    public Integer findSum(@PathVariable("typename")String typename);
    //查询指定数量小说
    @Select("select * from store order by id limit #{start},4")
    public List<Store> findnumberStore(@Param("start")Integer start);
    //查询所有小说数量
    @Select("select count(*) from store")
    public Integer findNums();

    //添加小说
    @Insert("insert into `store`(id,`typename`,`title`,`img`,`author`,`intro`,`score`,newtime,recmomend)VALUES(#{id},#{typename},#{title},#{img},#{author},#{intro},#{score},#{newtime},#{recmomend}) ")
    public void addStore(@Param("id") int id,@Param("typename") String typename,@Param("title") String title,@Param("img") String img,@Param("author") String author,@Param("intro") String intro,@Param("score") double score,@Param("newtime") String newtime,@Param("recmomend") String recmomend);
    //查找指定名称小说
    @Select("select * from store where  title=#{title}")
    public Store findTitle(@Param("title") String title);

    //修改评分
    @Update("update store set score = #{score} where id= #{id}")
    public void updateScore(@Param("score")double score,@Param("id")int id);

    /*通过id查找*/
    @Select("SELECT * from store where id=#{id}")
    public Store findById(@Param("id")int id);
}
