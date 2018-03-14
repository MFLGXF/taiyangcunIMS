package com.cr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.MD5Utils;
import com.cr.common.ReturnInfo;
import com.cr.domain.User;
import com.cr.service.impl.IuserService;
@RequestMapping("/admin")
@Controller
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
	/**
	 * 首页-领导班子
	 */
	@RequestMapping(value="/leader",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<User>> leader(){
		ReturnInfo<List<User>> ret = new ReturnInfo<List<User>>();
		List<User> leaderList = userService.leader();
		if(leaderList!=null){
			ret.setData(leaderList);
		}
		return ret;
	}
}
