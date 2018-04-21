package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.BalanceAndPayment;
import com.fwx.vo.PerformanceVO;

public interface BalanceAndPaymentMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public List<BalanceAndPayment> selectByName(BalanceAndPayment member);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(BalanceAndPayment pcData);

	/*
	 * 分页查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 获取过滤之后的列表
	 */
	public List<BalanceAndPayment> selectList(Map<String, Object> queryMap);

}
