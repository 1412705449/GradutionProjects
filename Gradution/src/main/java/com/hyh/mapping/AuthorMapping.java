package com.hyh.mapping;

import com.hyh.entity.Author;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorMapping {
    //ID查找对象
    @Select("select * from `author` where id=#{id}")
    public Author findId(@Param("id") String id);
    //用户名查找对象
    @Select("select * from `author` where username=#{name}")
    public Author findName(@Param("name") String name);
    //核对密码
    @Select("select count(*) from `author` where username=#{name} and password=md5(#{password})")
    public Integer SurePassword(@Param("name") String name,@Param("password") String password);
    //添加作者
    @Insert("insert into `author`(`username`,`password`,create_time)VALUES(#{name},md5(#{password}),#{create_time})")
    public void addAuthor(@Param("name") String name,@Param("password") String password,@Param("create_time") String create_time);
    //查询所有作者
    @Select("select * from `author`")
    public List<Author> findAllAuthor();
    //修改作者状态  正常
    @Update("update author set judgment = '1' where id=#{id}")
    public void updateAuthor1(Integer id);
    //修改作者状态  冻结
    @Update("update author set judgment = '0' where id=#{id}")
    public void updateAuthor0(Integer id);
}
