package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.BalanceAndPayment;

public interface IbalanceAndPaymentService {

	/*
	 * 添加会员卡信息
	 */
	public Boolean insert(BalanceAndPayment pcData);

	/*
	 * 获取所有数据
	 */
	public PageInfo<BalanceAndPayment> selectAll(Integer pageNumber, Integer pageSize, String workerName);


}
