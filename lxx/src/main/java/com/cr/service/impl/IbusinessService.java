package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Business;

public interface IbusinessService {
	public List<Business> selBusiness1();
	public List<Business> selBusiness2();
	public Business selBusinessByID(String id);
	public boolean addBusiness(Business business);
}
