package com.cr.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.ReturnInfo;
import com.cr.domain.Area;
import com.cr.service.impl.IareaService;

import ch.qos.logback.classic.Logger;

/*
 * 土地管理Controller
 */
@Controller
@RequestMapping("/area")
public class AreaController {

	Logger log = (Logger) LoggerFactory.getLogger(AreaController.class);

	@Autowired
	private IareaService areaService;

	/*
	 * 添加土地信息的接口
	 */
	@RequestMapping(value="/addArea",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<String> addArea(Area area){
		log.info("添加土地信息接口数据："+area.toString());
		ReturnInfo<String> result = new ReturnInfo<>();

		/*调用service层的方法进行添加或者更新*/
		Integer updateFlag = area.getUpdateFlag();
		if(updateFlag == 2){
			Integer updateRet = areaService.updateAreaById(area);
			if(updateRet != 0){
				result.setResult(200);
				result.setData("更新成功");
			}else{
				result.setData("更新失败");
				result.setResult(202);
			}
		}else{
			Boolean insertRet = areaService.saveArea(area);
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
	 * 查询土地所有信息
	 */
	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<List<Area>> dataGrid(){
		ReturnInfo<List<Area>> result = new ReturnInfo<>();

		List<Area> areaData = areaService.selectAll();

		log.info("获取土地列表数据："+areaData.toString());

		result.setData(areaData);
		return result;
	}

	/*
	 * 删除土地信息
	 */
	@RequestMapping("/deleteArea")
	@ResponseBody
	public ReturnInfo<String> deleteArea(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Boolean areaData = areaService.deleteArea(id);

		log.info("获取需要删除的土地id："+id);

		return result;
	}


	/*
	 * 删除土地信息
	 */
	@RequestMapping("/queryById")
	@ResponseBody
	public ReturnInfo<Area> queryAreaById(String id){
		ReturnInfo<Area> result = new ReturnInfo<>();
		log.info("获取需要删除的土地id："+id);
		Area areaData = areaService.findAreaById(id);

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

}
