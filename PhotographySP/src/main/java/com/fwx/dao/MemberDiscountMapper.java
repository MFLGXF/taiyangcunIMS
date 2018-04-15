package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.MemberDiscount;

public interface MemberDiscountMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public List<MemberDiscount> selectDiscountByType(MemberDiscount discount);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(MemberDiscount discount);

	/*
	 * 查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 查询该条件下的数据量
	 */
	public List<MemberDiscount> selectList(Map<String, Object> queryMap);

	/*
	 * 删除优惠方案
	 */
	public Integer delete(String id);

}
