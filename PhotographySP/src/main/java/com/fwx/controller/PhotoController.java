package com.fwx.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fwx.common.FileUtils;
import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.domain.Photo;
import com.fwx.service.IphotoService;
/**
 * 照片
 * @author sjdnw
 *
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {
	@Autowired
	private IphotoService photoService;
	
	@RequestMapping(value="/toAddPhoto",method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<Photo> toAddPhoto(HttpServletRequest request,String photoType,String username,String createname){
		ReturnInfo<Photo> ret = new ReturnInfo<Photo>();
		if("".equals(photoType) | "".equals(createname) | "".equals(username)){
			ret.setResult(201);
			return ret;
		}
	    request.getSession().setAttribute("username", username);
	    request.getSession().setAttribute("createname", createname);
	    request.getSession().setAttribute("photoType", photoType);
		ret.setResult(200);
		return ret;
		
	}
	@RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<Photo> addUserSingle(@RequestParam(value = "file") MultipartFile[] file,HttpServletRequest request) throws IOException, Exception{
		ReturnInfo<Photo> ret = new ReturnInfo<Photo>();
		String photoType =  (String) request.getSession().getAttribute("photoType");
		String userName =  (String) request.getSession().getAttribute("username");
		String createName =  (String) request.getSession().getAttribute("createname");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		Photo photo = new Photo();
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				  MultipartFile files = file[i];  
	                //保存文件  
				  String time = sdf.format(new Date());
				  String fileName =  photoType + "-"+ time +files.getOriginalFilename();	  
				  String filePath = request.getSession().getServletContext().getRealPath("upload/");
	              FileUtils.uploadFile(files.getBytes(), filePath, fileName);
	              photo.setPhotoName(fileName);
	  			  photo.setPhotoUrl(filePath + "\\"+ fileName);
		  		  photo.setId(UUIDUtils.getUuid32());
		  	      photo.setPhotoType(photoType);
		  	      photo.setUserName(userName);
		  	      photo.setCreateName(createName);
		  	      photo.setPhotoTime(new Date());
		  		  photo.setDelFlag("0");
		  		  photoService.addPhoto(photo);
			}
			ret.setResult(200);
			
		}
		
		return ret;
	}
	/**
	 * 查找照片
	 * @param pageNumber
	 * @param pageSize
	 * @param type
	 * @return
	 */
	@RequestMapping(value="selPhoto",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<PageInfo<Photo>> selPhoto(Integer pageNumber,Integer pageSize,String photoType,String username){
		ReturnInfo<PageInfo<Photo>> ret = new ReturnInfo<PageInfo<Photo>>();
		if("全部".equals(photoType)){
			photoType = null;
		}
		if("".equals(username)){
			username = null;
		}
		PageInfo<Photo> photoData = photoService.selPhoto(pageNumber, pageSize, photoType,username);
		ret.setData(photoData);
		ret.setResult(200);
		return ret;
	}
	/**
	 * 删除照片
	 */
	@RequestMapping(value="/delPhoto",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<String> delPhoto(String[] id,HttpServletRequest request){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		String filePath = request.getSession().getServletContext().getRealPath("upload/");
		boolean flag = photoService.delPhoto(id,filePath);
		
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
