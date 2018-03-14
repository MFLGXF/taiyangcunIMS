package com.cr.dao;

import java.util.List;
import java.util.Map;

import com.cr.domain.Area;

public interface AreaMapper {


	/*
	 * 添加土地信息
	 */
    public Integer insert(Area area);

    /*
     * 获取全部土地信息
     */
	public List<Area> selectList(Map<String, Object> queryMap);

	/*
	 * 根据id删除区域
	 */
	public Integer deleteArea(String id);

	/*
	 * 根据id查询区域
	 */
	public Area selectAreaById(String id);

	/*
	 * 根据地点数据更新数据
	 */
	public Integer updateAreaById(Area area);

	/*
	 * 各种条件下统计数量
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 根据标记查询数据
	 */
	public Integer findAreaByRecord(Map<String,Object> recordMap);


}