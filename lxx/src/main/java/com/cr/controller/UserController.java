package com.cr.controller;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.util.PoiPublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cr.common.FileUtils;
import com.cr.common.ReturnInfo;
import com.cr.common.StringUtils;
import com.cr.common.UUIDUtils;
import com.cr.domain.User;
import com.cr.service.impl.IuserService;
import com.cr.validator.IsIdCard;
import com.cr.validator.IsNumber;
import com.cr.validator.IsPhone;
import com.cr.vo.UserBean;
import com.cr.vo.UserCountVO;
import com.cr.vo.UserVO;

import junit.framework.Assert;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IuserService userService;
	/**
	 * 单个上传人口信息
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/addUserSingle", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<User> addUserSingle(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws ParseException{
		
		ReturnInfo<User> ret = new ReturnInfo<User>();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//必选项不能为空判断
		if(StringUtils.isEmpty(request.getParameter("name"))|StringUtils.isEmpty(request.getParameter("idcard"))|StringUtils.isEmpty(request.getParameter("birthday"))|StringUtils.isEmpty(request.getParameter("phone"))|StringUtils.isEmpty(request.getParameter("homestead"))|StringUtils.isEmpty(request.getParameter("address"))){
			ret.setResult(500);
			return ret;
		}
		boolean idcardFlag = IsIdCard.IDCardValidate(request.getParameter("idcard"));
		if(idcardFlag == false){
			//身份证验证不通过
			ret.setResult(202);
			return ret;
		}
		String phone = request.getParameter("phone").replaceAll(" ", ""); 
		String str = phone.substring(3, phone.length());
		boolean phoneFlag = IsPhone.isPhone(str);
		if(phoneFlag == false){
			//手机号验证不通过
			ret.setResult(203);
			return ret;
		}
		boolean homesteadFlag = IsNumber.isNumber(request.getParameter("homestead"));
		boolean landFlag = IsNumber.isNumber(request.getParameter("land"));
		if(homesteadFlag == false){
			//宅基地面积输入是否为数字验证不通过
			ret.setResult(204);
			return ret;
		}
		
		User user = new User();
		String id = UUIDUtils.getUuid32();
		
		user.setId(id);
		user.setName(request.getParameter("name"));
		user.setIdcard(request.getParameter("idcard"));
		user.setPhone(request.getParameter("phone"));
		String address = request.getParameter("address");
		user.setAddress(address);
		user.setBirthday(format.parse(request.getParameter("birthday")));
		user.setHomestead(Integer.valueOf(request.getParameter("homestead")));
		if(StringUtils.isEmpty(request.getParameter("land")) == true){
			user.setLand(0);
		}else{
			if(landFlag == false){
				//耕地面积输入是否为数字验证不通过
				ret.setResult(205);
				return ret;
			}
			user.setLand(Integer.valueOf(request.getParameter("land")));
		}
		String role = request.getParameter("role");
		user.setRole(role);
		user.setStatus("在住");
		String householder = request.getParameter("householder");
		user.setHouseholder(householder);
		user.setMarriage(request.getParameter("marriage"));
		user.setEducation(request.getParameter("education"));
		if(StringUtils.isEmpty(request.getParameter("occupation")) == true){
			user.setOccupation("暂无");
		}else{
			user.setOccupation(request.getParameter("occupation"));
		}
		
		user.setNation(request.getParameter("nation"));
		user.setSex(request.getParameter("sex"));
		if(StringUtils.isEmpty(request.getParameter("message")) == true){
			user.setMessage("无");
		}else{
			user.setMessage(request.getParameter("message"));
		}
		user.setDelflag(0);
		user.setCreatetime(new Date());
		//添加人员时判断职位是否存在
		boolean leaderFlag = userService.selLeader(id, role);
		if(leaderFlag == false){
			//该职位已存在
			ret.setResult(400);
			return ret;
		}
		//添加人员时先判断户主是否以存在
		boolean houseHolder = userService.selHouseholder(id, address,householder);
		if(houseHolder == false){
			ret.setResult(300);
			return ret;
		}
		if(file.isEmpty() == false){
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("upload/");
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			user.setPhoto(fileName);
		}else{
			user.setPhoto("admin.jpg");
		}
		
		
		boolean flag = userService.addUserSingle(user);
		
		if(flag == true){
			//添加成功
			ret.setResult(200);
		}else{
			//添加失败
			ret.setResult(201);
		}
		return ret;	
	}
	/**
	 * 批量导入人口信息
	 */
	@RequestMapping(value="/addUserBatch",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<User> addUserBatch(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<User> ret = new ReturnInfo<User>();
		if(file.isEmpty() == true){
			ret.setResult(203);
			return ret;
		}
		//以上传时间excel文件时间戳作为文件名
		String fileName =  new Date().getTime()+file.getOriginalFilename();
		//文件上传保存路径
		String filePath = request.getSession().getServletContext().getRealPath("excel/");
		try {
		    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
		        
		}
		ImportParams params = new ImportParams();
	    params.setTitleRows(1);
	    params.setHeadRows(1);
	    
	    List<UserVO> list = ExcelImportUtil.importExcel(
	       new File(filePath+fileName),
	       UserVO.class, params);
	    if(list.size() == 0){
	    	ret.setResult(202);
	    	return ret;
	    }
	    boolean flag = userService.addUserBatch(list);
	    if(flag == true){    	
	    	boolean delFlag = FileUtils.delete(filePath+fileName);
	    	if(delFlag == true){
	    		ret.setResult(200);
	    	}
	    }else{
	    	ret.setResult(201);
	    }
		return ret;	
	}
	/**
	 * 人口详情-人口照片墙
	 * @return
	 */
	@RequestMapping(value = "/userMessage", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<User>> userMessage(){
		ReturnInfo<List<User>> ret = new ReturnInfo<List<User>>();
		//按照姓氏进行排序显示
		List<User> userList = userService.userMessage();
		if(userList != null){
			ret.setData(userList);
		}
		return ret;
	}
	
	/**
	 * 查看单个人的具体信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(value="/selUserMessage",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<UserBean> selUserMessage(String id) throws IllegalAccessException, InvocationTargetException{
		ReturnInfo<UserBean> ret = new ReturnInfo<UserBean>();
		UserBean user = userService.selUserMessage(id);
		ret.setData(user);
		return ret;
	}
	/**
	 * 修改人员当前状态
	 */
	@RequestMapping(value="/updateStatus",method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<User> updateStatus(String id,String status){
		ReturnInfo<User> ret = new ReturnInfo<User>();
		boolean flag = userService.updateStatus(id, status);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
	/**
	 * 删除人员信息
	 */
	@RequestMapping(value="/delUser",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<User> delUser(String id){
		ReturnInfo<User> ret = new ReturnInfo<User>();
		boolean flag = userService.delUser(id);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
	/**
	 * 人口统计-出生和死亡 ， 在住和离村
	 */
	@RequestMapping(value="/proportion",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<UserCountVO> proportion(){
		ReturnInfo<UserCountVO> ret = new ReturnInfo<UserCountVO>();
		UserCountVO userCount = userService.selPro();
		if(userCount!=null){
			ret.setData(userCount);
		}
		return ret;
	}
	/**
	 * 修改村民信息
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<User> updateUser(String id,String name,String status,
			String phone,String occupation,String marriage,String role,Integer land,Integer homestead,
			String education,String nation,String address,String idcard ){
		ReturnInfo<User> ret = new ReturnInfo<User>();
		if(StringUtils.isEmpty(id)|StringUtils.isEmpty(name)
				|StringUtils.isEmpty(phone)|StringUtils.isEmpty(role)
				|StringUtils.isEmpty(land.toString())|StringUtils.isEmpty(homestead.toString())
				|StringUtils.isEmpty(address)|StringUtils.isEmpty(idcard)|StringUtils.isEmpty(occupation)
				|StringUtils.isEmpty(marriage)){
			ret.setResult(202);
			return ret;
		}
		boolean leaderFlag = userService.selLeader(id, role);
		if(leaderFlag == false){
			//该职位已存在
			ret.setResult(203);
			return ret;
		}
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setRole(role);
		user.setLand(land);
		user.setHomestead(homestead);
		user.setAddress(address);
		user.setIdcard(idcard);
		user.setStatus(status);
		user.setOccupation(occupation);
		user.setMarriage(marriage);
		user.setEducation(education);
		user.setNation(nation);

		boolean flag = userService.updateUser(user);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
	/**
	 * 查看户籍信息-以一户为单位
	 */
	@RequestMapping(value="selHome",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<User>> selHome(){
		ReturnInfo<List<User>> ret = new ReturnInfo<List<User>>();
		List<User> homeList = userService.selHome();
		if(homeList!=null){
			ret.setData(homeList);
		}
		return ret;
	}
	/**
	 * 模糊查询 - 用户
	 */
	@RequestMapping(value="selUser",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<List<User>> selUser(String name){
		ReturnInfo<List<User>> ret = new ReturnInfo<List<User>>();
		List<User> userList = userService.selUser(name);
		if(userList != null){
			ret.setData(userList);
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
