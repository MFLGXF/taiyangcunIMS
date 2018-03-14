package com.cr.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.ReturnInfo;
import com.cr.common.UUIDUtils;
import com.cr.domain.Plan;
import com.cr.service.impl.IplanService;
import com.cr.service.impl.newsServiceImpl;

@Controller
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	private IplanService planService;
	private  final Logger logger = LoggerFactory.getLogger(PlanController.class);
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
	/**
	 * 定时删除新闻 - 每天晚上1点定时触发，删除前一天的计划
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public boolean delNews(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Integer lastDay = Integer.valueOf(sdf.format(new Date()))-1;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf1.format(lastDay.toString());
		List<Plan> planList = planService.selOldPlan(time);
		if(planList!=null){
			for(int i=0;i<planList.size();i++){
				boolean flag = planService.delPlan(planList.get(i).getId());
				if(flag == false){
					  logger.debug("删除失败"+i);
				}
			}		
		}
		return false;
		
	}
}
