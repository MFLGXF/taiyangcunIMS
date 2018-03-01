package com.cr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.dao.UserMapper;
import com.cr.domain.User;
@Service
public class userServiceImpl implements IuserService {
	@Autowired
	private UserMapper userDao;
	/**
	 * 登录功能
	 */
	@Override
	public boolean login(String name,String password) {
		User user = new User();
		/**
		 * 通过登录名，密码，和权限进行登录。
		 */
		user.setName(name);
		user.setPassword(password);
		user.setRole("admin");
		List<User> userList = userDao.login(user);
		if(userList.size()>0){
			return true;
		}else{
			return false;
		}		
	}

}
