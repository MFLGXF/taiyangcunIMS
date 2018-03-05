package com.cr.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.ReturnInfo;
import com.cr.common.UUIDUtils;
import com.cr.domain.Plan;
import com.cr.service.impl.IplanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	private IplanService planService;
	/**
	 * 首页-显示近期计划
	 * @return
	 */
	@RequestMapping(value="/selPlan",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<Plan>> selPlan(){
		ReturnInfo<List<Plan>> ret = new ReturnInfo<List<Plan>>();
		List<Plan> planList = planService.selPlan();
		if(planList != null){
			ret.setData(planList);
		}
		return ret;
	}
	/**
	 * 信息管理-计划管理-添加计划
	 * @throws ParseException 
	 */
	@RequestMapping("/addPlan")
	@ResponseBody
	public ReturnInfo<Plan> addPlan(String planName,String planMessage,String createTime) throws ParseException{
		ReturnInfo<Plan> ret = new ReturnInfo<Plan>();
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Plan plan = new Plan();
		plan.setId(UUIDUtils.getUuid32());
		plan.setPlanName(planName);
		plan.setPlanMessage(planMessage);
		plan.setCreateTime(format.parse(createTime));
		plan.setDelFlag("0");
		boolean flag = planService.addPlan(plan);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
