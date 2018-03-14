package com.cr.service.impl;

import java.util.List;

import com.cr.common.PageInfo;
import com.cr.domain.Area;
import com.cr.domain.Asset;

/*
 * 土地管理service接口
 */
public interface IassetService {

	/*
	 * 登记土地，将土地信息保存在数据库中
	 */
	public Boolean saveAsset(Asset asset);

	/*
	 * 获取土地列表
	 */
	//public List<Asset> selectAll();

	/*
	 * 删除单挑土地信息
	 */
	public Boolean deleteAsset(String id);

	/*
	 * 根据id查询数据
	 */
	public Asset findAssetById(String id);

	/*
	 * 更新土地数据
	 */
	public Integer updateAssetById(Asset asset);

	/*
	 * 分页查询数据
	 */
	public PageInfo<Asset> selectList(Integer offset, Integer limit, String assetNumber, String assetPersonId, Integer assetStatus);

}
