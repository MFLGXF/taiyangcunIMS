package com.fwx.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.Economy;
import com.fwx.domain.Product;
import com.fwx.service.IeconomyService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/economy")
public class EconomyController {

	Logger log = (Logger) LoggerFactory.getLogger(EconomyController.class);

	@Autowired
	private IeconomyService economyService;
	/**
	 * 添加套系信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<Economy> add(Economy pcData) throws Exception{
		ReturnInfo<Economy> ret = new ReturnInfo<>();
		Boolean result = economyService.insert(pcData);
		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}
		return ret;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<Economy> update(String  ids,String eId){
		ReturnInfo<Economy> ret = new ReturnInfo<>();

		Boolean result = economyService.update(ids,eId);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}



	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<Economy>> dataGrid(){

		ReturnInfo<PageInfo<Economy>> result = new ReturnInfo<>();
		PageInfo<Economy> memberData = economyService.selectAll();

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

		Boolean areaData = economyService.delete(id);

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
