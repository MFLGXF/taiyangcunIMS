package com.cr.dao;

import com.cr.domain.News;
import com.cr.domain.NewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(String id);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    //首页-新闻
    List<News> selNews();
    
    List<News> selOldNews(String time);
}