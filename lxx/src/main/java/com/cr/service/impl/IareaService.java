package com.cr.service.impl;

import java.util.List;

import com.cr.common.PageInfo;
import com.cr.domain.Area;
import com.cr.vo.StaticDataVO;

/*
 * 土地管理service接口
 */
public interface IareaService {

	/*
	 * 登记土地，将土地信息保存在数据库中
	 */
	public Boolean saveArea(Area area);

	/*
	 * 获取土地列表
	 */
	public PageInfo<Area> selectAll(Integer pageNumber, Integer pageSize,
			String areaAddress, String personId, String rentPersonId, Integer areaConfirm, Integer areaRent);

	/*
	 * 删除单挑土地信息
	 */
	public Boolean deleteArea(String id);

	/*
	 * 根据id查询数据
	 */
	public Area findAreaById(String id);

	/*
	 * 更新土地数据
	 */
	public Integer updateAreaById(Area area);

	/*
	 * 根据标识统计数据
	 */
	public List<StaticDataVO> findAreaByRecord(String record);

}
