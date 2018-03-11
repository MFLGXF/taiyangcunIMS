package com.cr.service.impl;

import java.util.List;

import com.cr.common.PageInfo;
import com.cr.domain.Area;
import com.cr.domain.SecurityHouse;
import com.cr.vo.StaticDataVO;

/*
 * 土地管理service接口
 */
public interface IsecurityService {

	/*
	 * 获取土地列表
	 */
	public PageInfo<SecurityHouse> selectAll(Integer pageNumber, Integer pageSize);

	/*
	 * 更新房屋安全数据
	 */
	public Integer updateSecurity(SecurityHouse securityData);


}
