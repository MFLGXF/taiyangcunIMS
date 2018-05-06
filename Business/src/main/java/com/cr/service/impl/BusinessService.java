package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Business;

public interface BusinessService {
	public List<Business> selAllBusiness();
	public List<Business> selBusChecked();
	public Business selBusinessById(String id);
	public boolean delBusiness(String id);
	public boolean updateBusiness(Business business);
	
}
