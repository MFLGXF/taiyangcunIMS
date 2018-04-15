package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.MemberDiscount;

public interface ImemberdiscountService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(MemberDiscount discount);

	/*
	 * 获取所有数据
	 */
	public PageInfo<MemberDiscount> selectAll(Integer pageNumber, Integer pageSize, String cardTypeName);

	/*
	 * 根据id删除折扣方案信息
	 */
	public Boolean deleteDiscount(String id);

	/*
	 * 删除折扣信息
	 */
	public Boolean update(MemberDiscount discount);

	/*
	 * 获取所有的数据
	 */
	public PageInfo<MemberDiscount> list();

}
