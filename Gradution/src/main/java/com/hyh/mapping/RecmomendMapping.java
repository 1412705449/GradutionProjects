package com.hyh.mapping;

import com.hyh.entity.Recmomend;
import com.hyh.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecmomendMapping {
    //查询推荐
    //@Select("select recmomend.id as id,title,img,store_id,create_time,score from recmomend LEFT JOIN store ON recmomend.id=store.id ORDER BY store.score desc limit 3")
    @Select("select * from store ORDER BY store.score desc limit 3")
    public List<Store> findAllRecmomend();
    @Select("select * from store where typename='女频频道'  ORDER BY store.score desc limit 2")
    public List<Store> findNvRecmomend();
    //查找推荐小说
    @Select("select * from recmomend where store_id=#{store_id}")
    public Recmomend findId(@Param("store_id")Integer store_id);
}
