package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.Product;

public interface IproductService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(Product pcData);

	/*
	 * 获取所有数据
	 */
	public PageInfo<Product> selectAll(Integer pageNumber, Integer pageSize, String pName);

	/*
	 * 根据id删除信息
	 */
	public Boolean delete(String id);

	/*
	 * 删除信息
	 */
	public Boolean update(Product discount);

	/*
	 * 获取所有的数据
	 */
	public PageInfo<Product> list();

}
