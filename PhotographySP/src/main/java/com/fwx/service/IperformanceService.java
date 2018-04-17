package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.Economy;
import com.fwx.vo.PerformanceVO;

public interface IperformanceService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(PerformanceVO pcData);

	/*
	 * 获取所有数据
	 */
	public PageInfo<PerformanceVO> selectAll(Integer pageNumber, Integer pageSize, String workerName);

	/*
	 * 根据id删除信息
	 */
	public Boolean delete(String id);

	/*
	 * 删除信息
	 */
	public Boolean update(String ids,String eId);

	/*
	 * 获取所有的数据
	 */
	public PageInfo<PerformanceVO> list();

}
