package com.cr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.dao.BusinessMapper;
import com.cr.domain.Business;
@Service
public class businessServiceImpl implements IbusinessService {
	@Autowired
	private BusinessMapper businessDao;
	/**
	 * 查外来企业
	 */
	@Override
	public List<Business> selBusiness1() {
		List<Business> businessList = businessDao.selBusiness1();
		if(businessList.size()>0){
			return businessList;
		}
		return null;
	}
	/**
	 * 查本地企业
	 */
	@Override
	public List<Business> selBusiness2() {
		List<Business> businessList = businessDao.selBusiness1();
		if(businessList.size()>0){
			return businessList;
		}
		return null;
	}
	/**
	 * 通过ID查询一个企业的具体信息
	 */
	@Override
	public Business selBusinessByID(String id) {
		Business business = businessDao.selectByPrimaryKey(id);
		
		return business;
	}
	/**
	 * 添加企业
	 */
	@Override
	public boolean addBusiness(Business business) {
		int flag =  businessDao.insert(business);
		if(flag>0){
			return true;
		}
		return false;
	}

}
