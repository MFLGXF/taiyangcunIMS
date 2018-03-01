package com.cr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.MD5Utils;
import com.cr.common.ReturnInfo;
import com.cr.domain.User;
import com.cr.service.impl.IuserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private IuserService userService;
	/**
	 * 登录功能
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ReturnInfo<User> login(String name,String password){
		ReturnInfo<User> ret = new ReturnInfo<User>();
		if("".equals(name)||"".equals(password)){
			ret.setResult(202);
			return ret;
		}
		String pwd = MD5Utils.md5(password);
		boolean flag = userService.login(name,pwd);
		if(flag == true){//查找到了登录用户
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
