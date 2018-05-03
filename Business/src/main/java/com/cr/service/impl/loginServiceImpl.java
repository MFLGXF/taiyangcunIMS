package com.cr.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.dao.AdminMapper;
import com.cr.dao.BusinessMapper;
import com.cr.dao.UserMapper;
import com.cr.domain.Admin;
import com.cr.domain.Business;
import com.cr.domain.User;

@Service
public class loginServiceImpl implements LoginService {
	@Autowired
	private AdminMapper adminDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private BusinessMapper businessDao;
	@Override
	public boolean login(HttpServletRequest request,String username, String password, String type) {
		if("User".equals(type)){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User user1 = userDao.login(user);
			request.getSession().setAttribute("username", username);
			if(user1 != null){
				return true;
			}
		}else if("Business".equals(type)){
			Business bus = new Business();
			bus.setBusLoginname(username);
			bus.setBusPassword(password);
			Business bus1 = businessDao.login(bus);
			request.getSession().setAttribute("username", username);
			if(bus1 != null){
				return true;
			}
		}else if("Admin".equals(type)){
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			Admin admin1 = adminDao.login(admin);
			request.getSession().setAttribute("username", username);
			if(admin1 != null){
				return true;
			}
		}else{
			return false;
		}
		return false;
	}
	@Override
	public boolean userRegister(User user) {
		int flag = userDao.insert(user);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean businessRegister(Business business) {
		int flag = businessDao.insert(business);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean selUser(String username) {
		User user = userDao.selUser(username);
		if(user == null){
			return true;
		}
		return false;
	}
	@Override
	public boolean selBuniessByName(String name) {
		Business bus = businessDao.selBuniessByName(name);
		if(bus == null){
			return true;
		}
		return false;
	}
	@Override
	public boolean selBuniessByUsername(String username) {
		Business bus = businessDao.selBuniessByUsername(username);
				
		if(bus == null){
			return true;
		}
		return false;
	}

}
