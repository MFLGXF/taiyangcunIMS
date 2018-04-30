package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.Member;
import com.fwx.domain.Order;

public interface OrderMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public List<Order> selectOrderByName(Order order);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(Order member);

	/*
	 * 分页查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 获取过滤之后的列表
	 */
	public List<Order> selectList(Map<String, Object> queryMap);

	/*
	 * 删除数据
	 */
	public Integer delete(String id);

	/*
	 * 获取一个discountID对应的会员卡数量
	 */
	public Integer selectMemberByDiscountId(String id);

}
