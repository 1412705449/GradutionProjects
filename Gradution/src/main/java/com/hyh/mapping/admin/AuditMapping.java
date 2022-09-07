package com.hyh.mapping.admin;

import com.hyh.entity.Audit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditMapping {
    //查找所有审核小说
    @Select("select * from audit")
    public List<Audit> findAll();
    //查找所有审核小说
    @Select("select * from audit where id=#{id} ")
    public Audit findAudit(@Param("id") String id);

    //修改用户  通过
    @Update("update audit set judgment = '1' where id=#{id}")
    public void updateUser1(Integer id);
    //修改用户  拒绝
    @Update("update audit set judgment = '2' where id=#{id}")
    public void updateUser2(Integer id);
    //添加审核小说
    @Insert("insert into `audit`(`typename`,`title`,`img`,`author`,`intro`,score,newtime,storeChap) VALUES (#{typename},#{title},#{img},#{author},#{intro},#{score},#{newtime},#{storeChap}) ")
    public void addaudit(@Param("typename") String typename,@Param("title") String title,@Param("img") String img,@Param("author") String author,@Param("intro") String intro,@Param("score") double score,@Param("newtime") String newtime,@Param("storeChap") int storeChap);
    //添加审核小说章节
    @Insert("insert into `audit`(`order`,`store_id`,`chap`,content,create_time,storeChap) VALUES (#{order},#{store_id},#{chap},#{content},#{create_time},#{storeChap})")
    public void addauditChap(@Param("order") int order,@Param("store_id") int store_id,@Param("chap") String chap,@Param("content") String content,@Param("create_time") String create_time,@Param("storeChap") int storeChap);

}
