package com.cr.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.cr.domain.Business;
import com.cr.domain.User;

public interface LoginService {
	public boolean login(HttpServletRequest request,String username,String password,String type);
	public boolean userRegister(User user);
	public boolean businessRegister(Business business);
	public boolean selUser(String username);
	public boolean selBuniessByName(String name);
	public boolean selBuniessByUsername(String name);
	/*
	 * 根据用户名检测用户是否存在
	 */
    public boolean selUserByName(User user);
}
