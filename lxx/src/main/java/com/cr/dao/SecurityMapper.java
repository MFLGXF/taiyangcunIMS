package com.cr.dao;

import java.util.List;
import java.util.Map;

import com.cr.domain.Asset;
import com.cr.domain.SecurityHouse;

public interface SecurityMapper {


	/*
	 * 添加房屋安全信息
	 */
    public Integer insert(SecurityHouse house);


	/*
	 * 根据id查询资产
	 */
	public Asset selectAssetById(String id);

	/*
	 * 根据资产数据更新数据
	 */
	public Integer updateAssetById(Asset asset);

	/*
	 * 查询当前数据条数
	 */
	public Integer selectCount(Map<String,Object> queryMap);

	/*
	 * 分页查询
	 */
	public List<SecurityHouse> selectList(Map<String,Object> queryMap);

	/*
	 * 删除安全信息
	 */
	public Integer deleteSecurity(String id);

	/*
	 * 更新安全数据
	 */
	public Integer updateSecurityById(SecurityHouse securityData);


}