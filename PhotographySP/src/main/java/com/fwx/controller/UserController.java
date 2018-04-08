package com.fwx.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fwx.common.FileUtils;
import com.fwx.common.ReturnInfo;
import com.fwx.common.StringUtils;
import com.fwx.common.UUIDUtils;
import com.fwx.domain.Customer;
import com.fwx.domain.Worker;
import com.fwx.service.IworkerService;
import com.fwx.validator.IsBankCard;
import com.fwx.validator.IsIdCard;
import com.fwx.validator.IsPhone;



@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IworkerService workerService;
	
	@RequestMapping(value="/selWorker",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<Worker>> selectAll(){
		ReturnInfo<List<Worker>> ret = new ReturnInfo<List<Worker>>();
		List<Worker> list = workerService.selectAll();
		if(list != null){
			ret.setResult(200);
			ret.setData(list);
		}
		return ret;
	}
	@RequestMapping(value="searchWorker",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<List<Worker>> searchWorker(String name){
		ReturnInfo<List<Worker>> ret = new ReturnInfo<List<Worker>>();
		List<Worker> list = workerService.searchWorker(name);
		if(list != null){
			ret.setResult(200);
			ret.setData(list);
		}
		return ret;
	}
	@RequestMapping(value = "addWorker", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<String> addWorker(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws Exception, IOException{
		ReturnInfo<String> ret = new ReturnInfo<String>();
		Worker worker = new Worker();
		
		String workerName = request.getParameter("workerName");
		String workerPost = request.getParameter("workerPost");
		String wages = request.getParameter("wages");
		if(StringUtils.isEmpty(workerName) || StringUtils.isEmpty(wages) || StringUtils.isEmpty(workerPost)){
			ret.setResult(204); //有空
			return ret;
		}
		String workerIdCard = request.getParameter("workerIdCard");
		boolean idCardFlag = IsIdCard.IDCardValidate(workerIdCard);
		
		if(idCardFlag == false){
			ret.setResult(201);; // 身份证验证失败
			return ret;
		}
		String workerPhone = request.getParameter("workerPhone");
		boolean phoneFlag = IsPhone.isPhone(workerPhone);
		if(phoneFlag == false){
			ret.setResult(202); // 手机号验证失败
			return ret;
		}		
		String workerBankCard = request.getParameter("workerBankCard");
		boolean bankCardFlag = IsBankCard.checkBankCard(workerBankCard);
		if(bankCardFlag == false){
			ret.setResult(203); // 银行卡号验证失败
			return ret;
		}
		//String contentType = file.getContentType();
	    String fileName =  UUID.randomUUID()+file.getOriginalFilename();
	    
	    /*System.out.println("fileName-->" + fileName);
	    System.out.println("getContentType-->" + contentType);*/
	    String filePath = request.getSession().getServletContext().getRealPath("upload/");
	    try {
	        FileUtils.uploadFile(file.getBytes(), filePath, fileName);
	    } catch (Exception e) {
	        
	    }
	    //返回json
	    worker.setWorkerName(workerName);
	    worker.setWorkerPost(workerPost);
	    worker.setWages(wages);
	    worker.setWorkerBankCard(workerBankCard);
	    worker.setWorkerIdcard(workerIdCard);
	    worker.setWorkerPhone(workerPhone);
	    worker.setPhoto(fileName);
	    worker.setJoinTime(new Date());
	    worker.setDelFlag("0");
	    worker.setAvaFlag("1");
	    boolean flag = workerService.addWorker(worker);
	    if(flag == true){
	    	ret.setResult(200);
	    }
		return ret;
	}
	@RequestMapping("/delWorker")
	@ResponseBody
	public ReturnInfo<String> delWorker(String[] id){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		if(id == null){
			ret.setResult(202); //未选择数据
			return ret;
		}
		boolean flag = workerService.delWorker(id);
		if(flag == true){
			ret.setResult(200);
			return ret;
		}else{
			ret.setResult(201);
			return ret;
		}
		
	}
	/**
	 * 添加客户信息
	 */
	@RequestMapping(value="addCustomer",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<Customer> addCustomer(String name,String phone,String isvip){
		ReturnInfo<Customer> ret = new ReturnInfo<Customer>();
		if("".equals(name) | "".equals(phone) ){
			ret.setResult(202);
			return ret;
		}
		boolean phoneFlag = IsPhone.isPhone(phone);
		if(phoneFlag == false){
			ret.setResult(201); // 手机号验证失败
			return ret;
		}		
		Customer customer = new Customer();
		customer.setId(UUIDUtils.getUuid32());
		customer.setName(name);
		customer.setPhone(phone);
		customer.setIsVip(isvip);
		customer.setDelFlag("0");
		customer.setCreateTime(new Date());
		boolean flag = workerService.addCustomer(customer);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	/**
	 * 显示客户列表
	 * @return
	 */
	@RequestMapping(value="selCustomer",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<Customer>> selCustomer(){
		ReturnInfo<List<Customer>> ret = new ReturnInfo<List<Customer>>();
		List<Customer> list = workerService.selCustomer();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	/**
	 * 输入客户姓名查找
	 * @return
	 */
	@RequestMapping(value="searchCustomer",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<List<Customer>> searchCustomer(String name){
		ReturnInfo<List<Customer>> ret = new ReturnInfo<List<Customer>>();
		List<Customer> list = workerService.searchCustomer(name);
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	@RequestMapping(value="delCustomer",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<String> delCustomer(String[] id){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		return ret;
	}
}
