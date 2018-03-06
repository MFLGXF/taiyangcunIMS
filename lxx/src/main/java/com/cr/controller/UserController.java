package com.cr.controller;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
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
		if(landFlag == false){
			//耕地面积输入是否为数字验证不通过
			ret.setResult(205);
			return ret;
		}
		User user = new User();
		user.setId(UUIDUtils.getUuid32());
		user.setName(request.getParameter("name"));
		user.setIdcard(request.getParameter("idcard"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setBirthday(format.parse(request.getParameter("birthday")));
		user.setHomestead(Integer.valueOf(request.getParameter("homestead")));
		user.setLand(Integer.valueOf(request.getParameter("land")));
		user.setRole(request.getParameter("role"));
		user.setStatus("在住");
		user.setDelflag(0);
		user.setCreatetime(new Date());
		String fileName =  UUID.randomUUID()+file.getOriginalFilename();
		String filePath = request.getSession().getServletContext().getRealPath("upload/");
		try {
		    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
		        
		}
		user.setPhoto(fileName);
		
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
	@RequestMapping("/addUserBatch")
	@ResponseBody
	public ReturnInfo<User> addUserBatch(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		
		//以上传时间excel文件时间戳作为文件名
		String fileName =  new Date().getTime()+file.getOriginalFilename();
		//文件上传保存路径
		String filePath = request.getSession().getServletContext().getRealPath("excel/");
		try {
		    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
		        
		}
		try {
            ImportParams params = new ImportParams();
            params.setNeedSave(true);
            params.setSaveUrl(filePath);
            List<UserVO> result = ExcelImportUtil.importExcel(
                    new File(PoiPublicUtil.getWebRootPath("excel/"+fileName+".xls")),
                    UserVO.class, params);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.get(i)));
            }
            Assert.assertTrue(result.size() == 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;	
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
	@RequestMapping("/delUser")
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
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<User> updateUser(String id,String name,
			String phone,String role,Integer land,Integer homestead,
			String address,String idcard ){
		ReturnInfo<User> ret = new ReturnInfo<User>();
		if(StringUtils.isEmpty(id)|StringUtils.isEmpty(name)|StringUtils.isEmpty(phone)|StringUtils.isEmpty(role)|StringUtils.isEmpty(land.toString())|StringUtils.isEmpty(homestead.toString())|StringUtils.isEmpty(address)|StringUtils.isEmpty(idcard)){
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
		boolean flag = userService.updateUser(user);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
