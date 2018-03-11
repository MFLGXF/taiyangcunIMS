package com.cr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.common.PageInfo;
import com.cr.common.UUIDUtils;
import com.cr.dao.AssetMapper;
import com.cr.domain.Asset;

import ch.qos.logback.classic.Logger;
@Service
public class AssetServiceImpl implements IassetService{

	Logger log = (Logger) LoggerFactory.getLogger(AssetServiceImpl.class);

	/*
	 * 注入属性
	 */
	@Autowired
	private AssetMapper assetMapper;

	/*
	 * (将资产信息保存到数据库中)
	 * @see com.cr.service.impl.IssetService#saveAsset(com.cr.domain.Asset)
	 */
	@Override
	public Boolean saveAsset(Asset asset) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = format.format(new Date());
		if(asset != null){
			String personData = asset.getPersonId();
			if(personData != null && personData.contains("&")){
				asset.setPersonId(personData.split("&")[0]);
				asset.setPersonName(personData.split("&")[1]);
			}
		}
		/*设置土地信息的id*/
		asset.setId(UUIDUtils.getUuid32());
		asset.setDeleteFlag(1);

		asset.setCreateTime(createTime);

		log.info("包装完之后的asset信息："+asset.toString());

		/* 调用数据操作方法，将area保存到数据库中*/
		Integer result = assetMapper.insert(asset);

		if(result != 0){
			return true;
		}

		return false;
	}

	/*
	 * 获取土地信息列表
	 * @see com.cr.service.impl.IssetService#selectAll()
	 */

	/*public List<Asset> selectAll() {
		//List<Asset> result = assetMapper.selectList();
		log.info("获取的表中的数据："+result.toString());
		return result;
	}*/

	/*
	 * (删除对应 信息)
	 * @see com.cr.service.impl.IssetService#deleteAsset(java.lang.String)
	 */
	@Override
	public Boolean deleteAsset(String id) {
		log.info("进入service中删除方法！");
		Integer result = assetMapper.deleteAsset(id);
		log.info("根据id删除资产信息成功！");
		if(result != 0){
			return true;
		}
		return false;
	}

	/*
	 * (根据id查询数据)
	 * @see com.cr.service.impl.IassetService#findAssetById(java.lang.String)
	 */
	@Override
	public Asset findAssetById(String id) {
		return assetMapper.selectAssetById(id);
	}

	/*
	 * (更新土地数据)
	 * @see com.cr.service.impl.IassetService#updateAssetById(com.cr.domain.Asset)
	 */
	@Override
	public Integer updateAssetById(Asset asset) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = format.format(new Date());
		if(asset != null){
			String personData = asset.getPersonId();
			if(personData != null && personData.contains("&")){
				asset.setPersonId(personData.split("&")[0]);
				asset.setPersonName(personData.split("&")[1]);
			}
		}
		/*设置土地信息的id*/
		//asset.setDeleteFlag(1);
		asset.setChangeTime(createTime);

		log.info("包装完之后的asset信息："+asset.toString());

		/* 调用数据操作方法，将area保存到数据库中*/

		return assetMapper.updateAssetById(asset);
	}

	/*
	 * (分页查询数据)
	 * @see com.cr.service.impl.IassetService#selectList(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public PageInfo<Asset> selectList(Integer pageNumber, Integer pageSize, String assetNumber, String assetPersonId,
			Integer assetStatus) {
		PageInfo<Asset> page = new PageInfo<>();

		log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("assetNumber", assetNumber);
		queryMap.put("assetPersonId", assetPersonId);
		queryMap.put("assetStatus", assetStatus);

		Integer count = assetMapper.selectCount(queryMap);
		page.setTotalRow(count);
		page.setPageSize(pageSize);
		/*需要计算当前的页数和总页数*/
		page.setPageNumber(pageNumber);
		int totalPageNum = count%pageSize;
		int totalPage = count/pageSize;
		if(totalPageNum != 0){
			totalPage++;
		}
		page.setTotalPage(totalPage);
		page.setTotalPage(2);

		if(pageNumber <= 0){
			pageNumber = 1;
		}

		int start = (pageNumber*pageSize)-pageSize;
		int end = (pageNumber*pageSize);
		if(start <= 0){
			start = 0;
		}


		queryMap.put("start", start);
		queryMap.put("end", end);


		List<Asset> result = assetMapper.selectList(queryMap);
		page.setList(result);
		return page;
	}


}
