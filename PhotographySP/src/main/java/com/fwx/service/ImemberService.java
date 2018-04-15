package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.Member;
import com.fwx.domain.MemberDiscount;

public interface ImemberService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(Member member) throws Exception;

	/*
	 * 获取所有数据
	 */
	public PageInfo<Member> selectAll(Integer pageNumber, Integer pageSize, String cardTypeName);

	/*
	 * 根据id删除折扣方案信息
	 */
	public Boolean deleteMember(String id);

	/*
	 * 删除折扣信息
	 */
	public Boolean update(Member member);

	/*
	 * 获取当前方案下面是否还有可用的会员卡
	 */
	public Integer listMemberByDiscountId(String id);

}
