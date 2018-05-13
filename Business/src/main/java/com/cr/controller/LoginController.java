package com.cr.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cr.common.FileUtils;
import com.cr.common.ReturnInfo;
import com.cr.common.UUIDUtils;
import com.cr.domain.Admin;
import com.cr.domain.Business;
import com.cr.domain.User;
import com.cr.service.impl.LoginService;
import com.cr.validator.IsEmail;
import com.cr.validator.IsPhone;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping(value="/toLogin",method=RequestMethod.POST)
	public ReturnInfo<String> toLogin(HttpServletRequest request,String username,String password,String type){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		boolean flag = loginService.login(request, username, password, type);
		if(flag == true){	
			if("User".equals(type)){
				ret.setResult(0);
			}else if("Business".equals(type)){
				ret.setResult(1);
			}else if("Admin".equals(type)){
				ret.setResult(2);
			}
		}else{
			if("Business".equals(type)){
				ret.setResult(400);
				return ret;
			}
			ret.setResult(201);
			
		}
		return ret;
	}
	
	@RequestMapping(value="/toRegister",method=RequestMethod.POST)
	public ReturnInfo<String> toRegister(HttpServletRequest request,String type){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		request.getSession().setAttribute("type", type);
		if("User".equals(type)){			
			ret.setResult(200);
		}else if("Business".equals(type)){
			ret.setResult(201);
		}else if("admin".equals(type)){
			ret.setResult(202);
		}
		return ret;
		
	}
	
	@RequestMapping(value="/userRegister",method=RequestMethod.POST)
	public ReturnInfo<String> userRegister(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		String name = request.getParameter("name").toString();
		String password1 = request.getParameter("password1").toString();
		String password2 = request.getParameter("password2").toString();
		String phone = request.getParameter("phone").toString();
		String email = request.getParameter("email").toString();
		
		if("".equals(name) | "".equals(password1) | "".equals(password2) | "".equals(phone) | "".equals(email)){
			//非空判断
			ret.setResult(201);
			return ret;
		}
		if(!password1.equals(password2)){
			//两次密码是否相同判断
			ret.setResult(202);
			return ret;
		}
		boolean phoneFlag = IsPhone.isPhone(phone);
		if(phoneFlag == false){
			//手机号校验
			ret.setResult(203);
			return ret;
		}
		boolean emailFlag = IsEmail.isEmail(email);
		if(emailFlag == false){
			ret.setResult(204);
			return ret;
		}
		boolean check = loginService.selUser(phone);
		if(check == false){
			ret.setResult(206);
			return ret;
		}
		User user = new User();
		user.setId(UUIDUtils.getUuid32());
		user.setUsername(phone);
		user.setPassword(password1);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		if(file.isEmpty() == false){
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("upload/");
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			user.setPhoto(fileName);
		}else{
			ret.setResult(205);
			return ret;
		}
		user.setRole(request.getSession().getAttribute("type").toString());
		
		boolean flag = loginService.userRegister(user);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value="/businessRegister",method=RequestMethod.POST)
	public ReturnInfo<String> businessRegister(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		String name = request.getParameter("name").toString();
		String password1 = request.getParameter("password1").toString();
		String password2 = request.getParameter("password2").toString();
		String license = request.getParameter("license").toString();
		String address = request.getParameter("address").toString();
		String username = request.getParameter("username").toString();
		
		if("".equals(name) | "".equals(password1) | "".equals(password2) | "".equals(license) | "".equals(address)){
			//非空判断
			ret.setResult(201);
			return ret;
		}
		if(!password1.equals(password2)){
			//两次密码是否相同判断
			ret.setResult(202);
			return ret;
		}
		boolean check1 = loginService.selBuniessByName(name);
		boolean check2 = loginService.selBuniessByUsername(username);
		if(check1 == false | check2 == false){
			ret.setResult(206);
			return ret;
		}
		Business business = new Business();
		business.setId(UUIDUtils.getUuid32());
		business.setBusLoginname(username);
		business.setBusPassword(password1);
		business.setBusName(name);
		business.setBusLicense(license);
		business.setBusAddress(address);
		business.setIsCheck("0");
		
		if(file.isEmpty() == false){
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("upload/");
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			business.setBusImg(fileName);
		}else{
			ret.setResult(205);
			return ret;
		}
		
		
		boolean flag = loginService.businessRegister(business);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
    public ReturnInfo<String> userRegister(User user){
        ReturnInfo<String> ret = new ReturnInfo<String>();
        
        
        if("".equals(user.getName()) | "".equals(user.getPassword()) | "".equals(user.getEmail())){
            //非空判断
            ret.setResult(201);
            return ret;
        }
        
        boolean emailFlag = IsEmail.isEmail(user.getEmail());
        if(emailFlag == false){
            ret.setMsg("邮件格式错误");
            ret.setResult(204);
            return ret;
        }
        boolean check = loginService.selUserByName(user);
        if(check == false){
            ret.setMsg("该账号已存在");
            ret.setResult(206);
            return ret;
        }
        user.setId(UUIDUtils.getUuid32());
        user.setRole("User");
                
        boolean flag = loginService.userRegister(user);
        if(flag == true){
            ret.setMsg("注册成功");
            ret.setData(user.getName());
            ret.setResult(200);
            return ret;
        }
        ret.setMsg("注册失败");
        return ret;
    }
	
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
    public ReturnInfo<String> userLogin(User user,HttpServletRequest request){
        ReturnInfo<String> ret = new ReturnInfo<String>();
        boolean flag = loginService.login(request, user.getName(), user.getPassword(), "User");
        if(flag == true){   
            ret.setMsg("登录成功");
            ret.setData(user.getName());
            
            ret.setResult(200);
        }else{
            ret.setMsg("不存在账号");
            ret.setResult(201);
        }
        return ret;
    }
	
}
