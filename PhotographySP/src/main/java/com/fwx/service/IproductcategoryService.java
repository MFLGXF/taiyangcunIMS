package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.ProductCategory;

public interface IproductcategoryService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(ProductCategory pcData);

	/*
	 * 获取所有数据
	 */
	public PageInfo<ProductCategory> selectAll(Integer pageNumber, Integer pageSize, String pcName);

	/*
	 * 根据id删除信息
	 */
	public Boolean delete(String id);

	/*
	 * 删除信息
	 */
	public Boolean update(ProductCategory discount);

	/*
	 * 获取所有的数据
	 */
	public PageInfo<ProductCategory> list();

}
