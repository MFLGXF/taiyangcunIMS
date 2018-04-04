package com.cr.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.PageInfo;
import com.cr.common.ReturnInfo;
import com.cr.domain.Area;
import com.cr.domain.Asset;
import com.cr.service.impl.IassetService;

import ch.qos.logback.classic.Logger;

/*
 * 资产管理Controller
 */
@Controller
@RequestMapping("/asset")
public class AssetController {

	Logger log = (Logger) LoggerFactory.getLogger(AssetController.class);

	@Autowired
	private IassetService assetService;

	/*
	 * 登记资产信息的接口
	 */
	@RequestMapping(value="/addAsset",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<String> addArea(Asset asset){
		log.info("登记资产信息接口数据："+asset.toString());
		ReturnInfo<String> result = new ReturnInfo<>();

		/*调用service层的方法进行添加或者更新*/
		Integer updateFlag = asset.getUpdateFlag();
		if(updateFlag == 2){
			Integer updateRet = assetService.updateAssetById(asset);
			if(updateRet != 0){
				result.setResult(200);
				result.setData("更新成功");
			}else{
				result.setData("更新失败");
				result.setResult(202);
			}
		}else{
			Boolean insertRet = assetService.saveAsset(asset);
			if(insertRet){
				result.setData("添加成功");
				result.setResult(200);
			}else{
				result.setData("添加失败");
				result.setResult(202);
			}
		}
		return result;
	}


	/*
	 * 删除土地信息
	 */
	@RequestMapping("/deleteAsset")
	@ResponseBody
	public ReturnInfo<String> deleteArea(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Boolean areaData = assetService.deleteAsset(id);

		log.info("获取需要删除的土地id："+id);

		return result;
	}


	/*
	 * 删除土地信息
	 */
	@RequestMapping("/queryById")
	@ResponseBody
	public ReturnInfo<Asset> queryAreaById(String id){
		ReturnInfo<Asset> result = new ReturnInfo<>();
		log.info("获取需要删除的土地id："+id);
		Asset areaData = assetService.findAssetById(id);

		log.info("获取的数据为："+areaData.toString());

		if(areaData != null){
			result.setData(areaData);
			result.setResult(200);
			result.setMsg("获取成功");
		}else{
			result.setResult(202);
		}
		return result;
	}

	@RequestMapping("/datagrid2")
	@ResponseBody
	public ReturnInfo<PageInfo<Asset>> dataGrid2(Integer pageNumber,Integer pageSize){
		ReturnInfo<PageInfo<Asset>> result = new ReturnInfo<>();

		PageInfo<Asset> areaData = assetService.selectList(pageNumber,pageSize);

		log.info("获取分页数据：pageNumber="+pageNumber+",pageSize="+pageSize);

		result.setData(areaData);

		return result;
	}

}
