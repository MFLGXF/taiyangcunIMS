package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.Economy;
import com.fwx.domain.Product;

public interface IeconomyService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(Economy pcData);

	/*
	 * 获取所有数据
	 */
	public PageInfo<Economy> selectAll();

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
	public PageInfo<Economy> list();

}
