package com.hyh.mapping;

import com.hyh.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapping {
    //根据id查询
    @Select("SELECT * from message where id=#{id}")
    public Message findById(@Param("id") int id);

    //查询所有留言
    @Select("SELECT * from message where store_id=#{store_id}")
    public List<Message> findAll(@Param("store_id") String store_id);
    //添加
    @Insert("insert into `message`(`user_id`,`store_id`,username,content,newtime)VALUES(#{user_id},#{store_id},#{username},#{content},#{newtime})")
    public void addMessage(@Param("user_id") int user_id,@Param("store_id") int store_id,@Param("username") String username,@Param("content") String content,@Param("newtime") String newtime);

    //删除
    @Delete("delete from message where id=#{id}")
    public void delMessage(@Param("id") int id);
}
