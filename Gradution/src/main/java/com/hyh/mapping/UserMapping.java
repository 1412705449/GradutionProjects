package com.hyh.mapping;

import com.hyh.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapping {
    //ID查找对象
    @Select("select * from `user` where id=#{id}")
    public User findId(@Param("id") String id);
    //用户名查找对象
    @Select("select * from `user` where username=#{name}")
    public User findName(@Param("name") String name);
    //核对密码
    @Select("select count(*) from `user` where username=#{name} and password=md5(#{password})")
    public Integer SurePassword(@Param("name") String name,@Param("password") String password);
    //添加用户
    @Insert("insert into `user`(`username`,`password`,create_time)VALUES(#{name},md5(#{password}),#{create_time})")
    public void addUser(@Param("name") String name,@Param("password") String password,@Param("create_time") String create_time);
    //查询所有用户
    @Select("select * from `user`")
    public List<User> findAll();
    //修改用户  正常
    @Update("update user set judgment = '1' where id=#{id}")
    public void updateUser1(Integer id);
    //修改用户  冻结
    @Update("update user set judgment = '0' where id=#{id}")
    public void updateUser0(Integer id);
}
