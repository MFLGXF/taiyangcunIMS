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
import org.springframework.web.multipart.MultipartFile;

import com.fwx.common.FileUtils;
import com.fwx.common.ReturnInfo;
import com.fwx.common.StringUtils;
import com.fwx.domain.Worker;
import com.fwx.service.IworkerService;
import com.fwx.validator.IsBankCard;
import com.fwx.validator.IsIdCard;
import com.fwx.validator.IsPhone;



@Controller
@RequestMapping("/worker")
public class WorkerController {
	@Resource
	private IworkerService workerService;
	@RequestMapping("/selWorker")
	public ReturnInfo<List<Worker>> selWorker(){
		ReturnInfo<List<Worker>> ret = new ReturnInfo<List<Worker>>();
		List<Worker> list = workerService.selAll();
	    ret.setData(list);		
		return ret;
	}
	@RequestMapping("/selectAll")
	public ReturnInfo<List<Worker>> selectAll(){
		ReturnInfo<List<Worker>> ret = new ReturnInfo<List<Worker>>();
		List<Worker> list = workerService.selectAll();
		if(list != null){
			ret.setData(list);
		}
		return ret;
	}
	@RequestMapping(value = "/addWorker", method = RequestMethod.POST)
	public ReturnInfo<String> addWorker(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws Exception, IOException{
		ReturnInfo<String> ret = new ReturnInfo<String>();
		Worker worker = new Worker();
		
		String workerName = request.getParameter("workerName");
		String workerPost = request.getParameter("workerPost");
		String wages = request.getParameter("wages");
		if(StringUtils.isEmpty(workerName) || StringUtils.isEmpty(wages) || StringUtils.isEmpty(workerPost)){
			ret.setData("204"); //有空
			return ret;
		}
		String workerIdCard = request.getParameter("workerIdCard");
		boolean idCardFlag = IsIdCard.IDCardValidate(workerIdCard);
		
		if(idCardFlag == false){
			ret.setData("201"); // 身份证验证失败
			return ret;
		}
		String workerPhone = request.getParameter("workerPhone");
		boolean phoneFlag = IsPhone.isPhone(workerPhone);
		if(phoneFlag == false){
			ret.setData("202"); // 手机号验证失败
			return ret;
		}		
		String workerBankCard = request.getParameter("workerBankCard");
		boolean bankCardFlag = IsBankCard.checkBankCard(workerBankCard);
		if(bankCardFlag == false){
			ret.setData("203"); // 银行卡号验证失败
			return ret;
		}	
		//String contentType = file.getContentType();
	    String fileName =  UUID.randomUUID()+file.getOriginalFilename();
	    
	    /*System.out.println("fileName-->" + fileName);
	    System.out.println("getContentType-->" + contentType);*/
	    String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
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
	    	ret.setData("200");
	    }
		return ret;
	}
	@RequestMapping("/delWorker")
	public ReturnInfo<String> delWorker(String[] id){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		if(id == null){
			ret.setData("202"); //未选择数据
			return ret;
		}
		boolean flag = workerService.delWorker(id);
		if(flag == true){
			ret.setData("200");
			return ret;
		}else{
			ret.setData("201");
			return ret;
		}
		
	}
	
}
