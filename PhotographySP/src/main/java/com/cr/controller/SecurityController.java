package com.cr.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.PageInfo;
import com.cr.common.ReturnInfo;
import com.cr.domain.Area;
import com.cr.domain.SecurityHouse;
import com.cr.service.impl.IsecurityService;

import ch.qos.logback.classic.Logger;

/*
 * 安全管理Controller
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

	Logger log = (Logger) LoggerFactory.getLogger(SecurityController.class);

	@Autowired
	private IsecurityService securityService;



	/*
	 * 查询土地所有信息
	 */
	@RequestMapping("/datagrid2")
	@ResponseBody
	public ReturnInfo<PageInfo<SecurityHouse>> dataGrid(
			Integer pageNumber,
			Integer pageSize
			){

		ReturnInfo<PageInfo<SecurityHouse>> result = new ReturnInfo<>();
		PageInfo<SecurityHouse> areaData = securityService.selectAll(pageNumber,pageSize);

		log.info("获取土地列表数据："+areaData.toString());

		result.setData(areaData);
		return result;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<String> update(
			SecurityHouse securityData
			){

		ReturnInfo<String> result = new ReturnInfo<>();
		Integer retData = securityService.updateSecurity(securityData);

		log.info("获取土地列表数据："+securityData.toString());

		result.setData("更新数据成功");
		return result;
	}

}
