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
		int flag = planDao.deleteByPrimaryKey(id);
		if(flag >0){
			return true;
		}
		return false;
	}

}
