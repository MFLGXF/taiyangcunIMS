package com.cr.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.cr.domain.User;
import com.cr.vo.UserBean;
import com.cr.vo.UserCountVO;

public interface IuserService {
	//登录功能
	public boolean login(String name,String password);
	//单个人员上传
	public boolean addUserSingle(User user);
	//查看人口信息
	public List<User> userMessage();
	//查看一个人口的具体信息
	public UserBean selUserMessage(String id) throws IllegalAccessException, InvocationTargetException;
	//修改一个人口的状态
	public boolean updateStatus(String id,String status);
	//删除一个人
	public boolean delUser(String id);
	//查询出生 死亡 在住 离村人员及比例
	public UserCountVO selPro();
	//查看领导
	public List<User> leader();
	//修改一个人口的信息
	public boolean updateUser(User user);
	//查询当前领导是否存在
	public boolean selLeader(String id ,String role);
	//查户籍信息
	public List<User> selHome();
	//查看一家是否有户主存在了
	public boolean selHouseholder(String id,String address,String householder);
}
