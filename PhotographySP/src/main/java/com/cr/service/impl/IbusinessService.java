package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Business;

public interface IbusinessService {
	public List<Business> selBusiness(String isLocal);
	public Business selBusinessByID(String id);
	public boolean addBusiness(Business business);
}
