package com.fwx.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.Economy;
import com.fwx.service.IperformanceService;
import com.fwx.vo.PerformanceVO;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/performance")
public class PerformanceController {

	Logger log = (Logger) LoggerFactory.getLogger(PerformanceController.class);

	@Autowired
	private IperformanceService performanceService;
	/**
	 * 添加套系信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<PerformanceVO> add(PerformanceVO pcData) throws Exception{
		ReturnInfo<PerformanceVO> ret = new ReturnInfo<>();
		Boolean result = performanceService.insert(pcData);
		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}
		return ret;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<PerformanceVO> update(String  ids,String eId){
		ReturnInfo<PerformanceVO> ret = new ReturnInfo<>();

		Boolean result = performanceService.update(ids,eId);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}



	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<PerformanceVO>> dataGrid(Integer pageNumber, Integer pageSize, String workerName){

		ReturnInfo<PageInfo<PerformanceVO>> result = new ReturnInfo<>();
		PageInfo<PerformanceVO> memberData = performanceService.selectAll(pageNumber, pageSize, workerName);

		log.info("获取折扣方案列表数据："+memberData.toString());

		result.setData(memberData);
		return result;
	}

	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ReturnInfo<String> deleteMember(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Boolean areaData = performanceService.delete(id);

		log.info("获取需要删除的 id："+id);

		if(areaData){
			result.setResult(200);
			result.setMsg("删除成功");
		}else{
			result.setResult(202);
			result.setMsg("删除失败！");
		}
		return result;
	}





}
