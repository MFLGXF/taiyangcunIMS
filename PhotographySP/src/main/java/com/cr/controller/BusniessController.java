package com.cr.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import com.cr.domain.Business;
import com.cr.service.impl.IbusinessService;

@Controller
@RequestMapping("/business")
public class BusniessController {
	@Autowired
	private IbusinessService businessService;
	/**
	 * 查企业  isLocal = 0：本地  1：外地
	 * @return
	 */
	@RequestMapping(value="/selBusiness",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<List<Business>> selBusiness(String isLocal){
		ReturnInfo<List<Business>> ret = new ReturnInfo<List<Business>>();
		List<Business> businessList = businessService.selBusiness(isLocal);
		if(businessList!=null){
			ret.setData(businessList);
		}
		return ret;
	}
	
	/**
	 * 通过ID查看企业具体信息
	 */
	@RequestMapping(value="/selBusinessByID")
	@ResponseBody
	public ReturnInfo<Business> selBusinessByID(String id){
		ReturnInfo<Business> ret = new ReturnInfo<Business>();
		Business business = businessService.selBusinessByID(id);
		if(business!=null){
			ret.setData(business);
		}
		return ret;
	}
	/**
	 * 业务管理-添加企业
	 */
	@RequestMapping(value="/addBusiness",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<Business> addBusiness(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws ParseException{
		ReturnInfo<Business> ret = new ReturnInfo<Business>();
		
		if(StringUtils.isEmpty(request.getParameter("companyName")) 
				|StringUtils.isEmpty(request.getParameter("companyLeader"))
				|StringUtils.isEmpty(request.getParameter("industry"))
				|StringUtils.isEmpty(request.getParameter("revenue"))
				|StringUtils.isEmpty(request.getParameter("scale"))|file.getSize()<0){
		
			ret.setResult(201);
			return ret;
		}
		
		Business business = new Business();
		business.setCompanyName(request.getParameter("companyName"));
		business.setCompanyLeader(request.getParameter("companyLeader"));
		business.setId(UUIDUtils.getUuid32());
		business.setIndustry(request.getParameter("industry"));
		business.setRevenue(request.getParameter("revenue"));
		business.setScale(Integer.valueOf(request.getParameter("scale")));
		business.setTaxes(String.valueOf((Integer.valueOf(request.getParameter("revenue"))*0.05)));
		business.setMessage(request.getParameter("message"));
		business.setIsLocal(Integer.valueOf(request.getParameter("isLocal")));
		
		String fileName =  UUID.randomUUID()+file.getOriginalFilename();
		String filePath = request.getSession().getServletContext().getRealPath("upload/");
		try {
		    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
		        
		}
		business.setLogo(fileName);
		
		boolean flag = businessService.addBusiness(business);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
