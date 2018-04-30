package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.Order;

public interface IorderService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(Order member) throws Exception;

	/*
	 * 获取所有数据
	 */
	public PageInfo<Order> selectAll(Integer pageNumber, Integer pageSize, String cardTypeName);

	/*
	 * 根据id删除折扣方案信息
	 */
	public Boolean deleteMember(String id);

	/*
	 * 删除折扣信息
	 */
	public Boolean update(Order member);

	/*
	 * 获取当前方案下面是否还有可用的会员卡
	 */
	public Integer listMemberByDiscountId(String id);

}
