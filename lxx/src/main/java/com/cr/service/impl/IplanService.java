package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Plan;

public interface IplanService {
	//首页-显示工作计划
	public List<Plan> selPlan();
	//添加计划
	public boolean addPlan(Plan plan);
	public List<Plan> selOldPlan(String time);
	public boolean delPlan(String id);
	public boolean updatePlan(String id,String planName,String planMessage);
	public Plan selPlanByID(String id);
	public List<Plan> todayPlan();
}
