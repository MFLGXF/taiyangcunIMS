package com.cr.dao;

import java.util.List;

import com.cr.domain.Area;
import com.cr.domain.Asset;

public interface AssetMapper {


	/*
	 * 添加资产信息
	 */
    public Integer insert(Asset asset);

    /*
     * 获取全部资产信息
     */
	//public List<Asset> selectList();

	/*
	 * 根据id删除资产
	 */
	public Integer deleteAsset(String id);

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
	public Integer selectCount();

	public List<Asset> selectList(int start, int end);


}