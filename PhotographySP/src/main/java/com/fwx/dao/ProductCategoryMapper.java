package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.Member;
import com.fwx.domain.ProductCategory;

public interface ProductCategoryMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public ProductCategory selectProductCategoryById(String id);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(ProductCategory pcData);

	/*
	 * 分页查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 获取过滤之后的列表
	 */
	public List<ProductCategory> selectList(Map<String, Object> queryMap);

	/*
	 * 删除数据
	 */
	public Integer delete(String id);

	/*
	 * 根据产品分类名称查询
	 */
	public List<ProductCategory> selectByName(String pcName);


}
