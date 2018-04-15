package com.fwx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.dao.UserMapper;
import com.fwx.domain.User;
import com.fwx.service.IuserService;

@Service
public class UserServiceImpl implements IuserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public boolean login(String username, String password) {
		User user = new User();
		/**
		 * 通过登录名，密码，和权限进行登录。
		 */
		System.out.println(username);
		System.out.println(password);
		user.setUsername(username);
		user.setPassword(password);
		List<User> userList = userDao.login(user);
		if(userList.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
