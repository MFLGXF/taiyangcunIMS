package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.Product;
import com.fwx.domain.ProductCategory;

public interface ProductMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public List<Product> selectByName(Product member);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(Product pcData);

	/*
	 * 分页查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 获取过滤之后的列表
	 */
	public List<Product> selectList(Map<String, Object> queryMap);

	/*
	 * 删除数据
	 */
	public Integer delete(String id);

	/*
	 * 根据pcName删除数据
	 */
	public Integer deleteByPcName(String pcName);


}
