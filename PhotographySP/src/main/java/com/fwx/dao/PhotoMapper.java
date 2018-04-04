package com.fwx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fwx.domain.Photo;
import com.fwx.domain.PhotoExample;

public interface PhotoMapper {
    int countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
    /*
	 * 分页查询
	 */
	public List<Photo> selectList(Map<String,Object> queryMap);
	/*
	 * 批量删除
	 */
	int delPhoto(String[] id); 
	/*
	 * 批量查找
	 */
	List<Photo> selPhotoByID(String[] id);
}