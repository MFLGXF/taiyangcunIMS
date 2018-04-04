package com.cr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.dao.PlanMapper;
import com.cr.domain.News;
import com.cr.domain.Plan;
@Service
public class planServiceImpl implements IplanService {
	@Autowired
	private PlanMapper planDao;
	@Override
	public List<Plan> selPlan() {
		List<Plan> planList = planDao.selPlan();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		if(planList.size()>0){
			for(int i=0;i<planList.size();i++){
				String createTime = sdf.format(planList.get(i).getCreateTime());
				if(time.equals(createTime)){
					planList.get(i).setTime("Today");
				}else if(Integer.valueOf(time)+1 == Integer.valueOf(createTime)){
					planList.get(i).setTime("Tomorrow");
				}else{
					planList.get(i).setTime(createTime);
				}
			}
			return planList;
		}
		return null;
	}
	/**
	 * 添加计划
	 */
	@Override
	public boolean addPlan(Plan plan) {
		int flag = planDao.insert(plan);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<Plan> selOldPlan(String time) {
		List<Plan> planList = planDao.selOldPlan(time);
		if(planList.size()>0){
			return planList;
		}
		return null;
	}
	@Override
	public boolean delPlan(String id) {
		Plan plan = new Plan();
		plan.setDelFlag("1");
		plan.setId(id);
		int flag = planDao.updateByPrimaryKeySelective(plan);
		if(flag >0){
			return true;
		}
		return false;
	}
	@Override
	public boolean updatePlan(String id, String planName, String planMessage) {
		Plan plan = new Plan();
		plan.setPlanName(planName);
		plan.setId(id);
		plan.setPlanMessage(planMessage);
		int flag = planDao.updateByPrimaryKeySelective(plan);
		if(flag >0){
			return true;
		}
		return false;
	}
	@Override
	public Plan selPlanByID(String id) {
		Plan plan = planDao.selectByPrimaryKey(id);
		if(plan != null){
			return plan;
		}
		return null;
	}
	@Override
	public List<Plan> todayPlan() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Plan> plan = planDao.todayPlan(sdf.format(new Date()));
		if(plan.size()>0){
			return plan;
		}
		return null;
	}

}
