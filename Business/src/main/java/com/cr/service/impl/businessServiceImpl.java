package com.cr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cr.dao.BusinessMapper;
import com.cr.domain.Business;
import com.cr.domain.BusinessExample;
@Service
public class businessServiceImpl implements BusinessService {
	@Resource
	private BusinessMapper businessDao;
	@Override
	public List<Business> selAllBusiness() {
		List<Business> list = businessDao.selectByExample(new BusinessExample());
		if(list.size() > 0){
			return list;
		}
		return null;
	}

	@Override
	public List<Business> selBusChecked() {
		List<Business> list = businessDao.selBusChecked();
		if(list.size() > 0){
			return list;
		}
		return null;
	}

	@Override
	public Business selBusinessById(String id) {
		Business business = businessDao.selectByPrimaryKey(id);
		if(business != null){
			return business;
		}
		return null;
	}

	@Override
	public boolean delBusiness(String id) {
		int flag = businessDao.deleteByPrimaryKey(id);
		if(flag > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBusiness(Business business) {
		int flag = businessDao.updateByPrimaryKeySelective(business);
		if(flag > 0){
			return true;
		}
		return false;
	}

	

}
