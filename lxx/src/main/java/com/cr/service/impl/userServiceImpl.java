package com.cr.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.dao.UserMapper;
import com.cr.domain.User;
import com.cr.vo.UserBean;
import com.cr.vo.UserCountVO;
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
	/**
	 * 单个登记人口
	 */
	@Override
	public boolean addUserSingle(User user) {
		int flag = userDao.insert(user);
		if(flag > 0){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 查看人口信息
	 */
	@Override
	public List<User> userMessage() {
		List<User> userList = userDao.userMessage();
		if(userList.size()>0){
			return userList;
		}else{
			return null;
		}
		
	}
	/**
	 * 查看一个人的具体信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Override
	public UserBean selUserMessage(String id) throws IllegalAccessException, InvocationTargetException {
		User user = userDao.selUserMessage(id);
		List<User> userHomeList = userDao.selUserHome(id, user.getAddress());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		UserBean userBean = new UserBean();
		if(userHomeList.size()>0){
		  for(int i=0;i<userHomeList.size();i++){		  
			  String birth = sdf.format(userHomeList.get(i).getBirthday());			  
			  userHomeList.get(i).setBirth(birth);
		  }
		  userBean.setUserList(userHomeList);
		}
		
		BeanUtils.copyProperties(userBean, user);
		  
		String birth = sdf.format(user.getBirthday());
		userBean.setBirthday(birth);
		return userBean;
		
	}
	/**
	 * 修改一个人的状态
	 */
	@Override
	public boolean updateStatus(String id,String status) {
		User user = new User();
		user.setId(id);
		user.setStatus(status);
		int flag = userDao.updateByPrimaryKeySelective(user);
		if(flag>0){
			return true;
		}
		return false;
	}
	/**
	 * 删除一个人
	 */
	@Override
	public boolean delUser(String id) {
		User user = new User();
		user.setId(id);
		user.setDelflag(1);
		int flag = userDao.updateByPrimaryKeySelective(user);
		if(flag > 0){
			return true;
		}
		return false;
	}
	/**
	 * 首页-占比统计
	 */
	@Override
	public UserCountVO selPro() {
		List<UserCountVO> bornList = userDao.selBorn();
		int bornCount = bornList.size();
		List<UserCountVO> deathList = userDao.selDeath();
		int deathCount = deathList.size();
		List<UserCountVO> liveList = userDao.selLive();
		int liveCount = liveList.size();
		List<UserCountVO> stayList = userDao.selStay();
		int stayCount = stayList.size();
		//计算占比
	    // 创建一个数值格式化对象  
		  
        NumberFormat numberFormat = NumberFormat.getInstance();  
  
        // 设置精确到小数点后2位  
  
        numberFormat.setMaximumFractionDigits(2);  
  
        String bornPro = numberFormat.format((float) bornCount / (float) (bornCount+deathCount) * 100);  
        String deathPro = numberFormat.format((float) deathCount / (float) (bornCount+deathCount) * 100);  
        String livePro = numberFormat.format((float) liveCount / (float) (liveCount+stayCount) * 100);  
        String stayPro = numberFormat.format((float) stayCount / (float) (liveCount+stayCount) * 100);  
		
		UserCountVO count = new UserCountVO();
		count.setNewBorn(bornCount);
		count.setDeath(deathCount);
		count.setStay(stayCount);
		count.setLive(liveCount);
		//
		count.setBornPro(bornPro);
		count.setDeathPro(deathPro);
		count.setLivePro(livePro);
		count.setStayPro(stayPro);
		return count;
	}
	/**
	 * 领导信息管理
	 */
	@Override
	public List<User> leader() {
		List<User> leaderList = userDao.leader();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		if(leaderList.size()>0){
			for(int i=0;i<leaderList.size();i++){			
				leaderList.get(i).setBirth(sdf.format(leaderList.get(i).getBirthday()));
			}
			return leaderList;
		}
		return null;
	}
	/**
	 * 修改村民信息
	 */
	@Override
	public boolean updateUser(User user) {
		int flag = userDao.updateByPrimaryKeySelective(user);
		if(flag > 0){
			return true;
		}
		return false;
	}
	/**
	 * 查看该职位是否存在
	 */
	@Override
	public boolean selLeader(String id, String role) {
		List<User> list = userDao.selLeader(id, role);
		if(list.size()>0){
			return false;
		}
		return true;
	}

}