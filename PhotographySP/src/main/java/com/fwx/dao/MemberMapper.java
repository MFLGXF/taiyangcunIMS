package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.Member;

public interface MemberMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public List<Member> selectMemberByName(Member member);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(Member member);

	/*
	 * 分页查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 获取过滤之后的列表
	 */
	public List<Member> selectList(Map<String, Object> queryMap);

	/*
	 * 删除数据
	 */
	public Integer delete(String id);

	/*
	 * 获取一个discountID对应的会员卡数量
	 */
	public Integer selectMemberByDiscountId(String id);

}
