package com.cr.service.impl;

import com.cr.domain.Business;
import com.cr.domain.User;

public interface LoginService {
	public boolean login(String username,String password,String type);
	public boolean userRegister(User user);
	public boolean businessRegister(Business business);
	public boolean selUser(String username);
	public boolean selBuniessByName(String name);
	public boolean selBuniessByUsername(String name);
}
