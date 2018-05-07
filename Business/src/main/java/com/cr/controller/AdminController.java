package com.cr.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cr.common.FileUtils;
import com.cr.common.ReturnInfo;
import com.cr.domain.Business;
import com.cr.domain.Goods;
import com.cr.service.impl.BusinessService;
import com.cr.service.impl.GoodsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private BusinessService businessService;
	@Resource
	private GoodsService goodsService;
	@RequestMapping(value = "/toAddGoods", method = RequestMethod.POST)
	public ReturnInfo<Goods> toAddGoods(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<Goods> ret = new ReturnInfo<Goods>();
		return ret;
	}
	
	@RequestMapping(value = "/toSelAllBusiness",method = RequestMethod.GET)
	public ReturnInfo<List<Business>> toSelAllBusiness(){
		ReturnInfo<List<Business>> ret = new ReturnInfo<List<Business>>();
		List<Business> list = businessService.selAllBusiness();
		if(list != null){
			ret.setData(list);
		}
		return ret;
	}
	
	@RequestMapping(value = "/toSelBusinessChecked",method = RequestMethod.GET)
	public ReturnInfo<List<Business>> toSelBusinessChecked(){
		ReturnInfo<List<Business>> ret = new ReturnInfo<List<Business>>();
		List<Business> list = businessService.selBusChecked();
		if(list != null){
			ret.setData(list);
		}
		return ret;
	}
	
	@RequestMapping(value = "/selBusinessById",method=RequestMethod.GET)
	public ReturnInfo<Business> selBusinessById(String id){
		ReturnInfo<Business> ret = new ReturnInfo<Business>();
		Business business = businessService.selBusinessById(id);
		if(business != null){
			ret.setData(business);
		}
		return ret;
		
	}
	
	@RequestMapping(value = "/delBusiness",method = RequestMethod.POST)
	public ReturnInfo<Business> delBusiness(String id){
		ReturnInfo<Business> ret = new ReturnInfo<Business>();
		boolean flag = businessService.delBusiness(id);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value = "/updateBusiness",method = RequestMethod.POST)
	public ReturnInfo<String> updateBusiness(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		String busName = request.getParameter("busName").toString();
		String busLicense = request.getParameter("busLicense").toString();
		String busAddress = request.getParameter("busAddress").toString();
		String id = request.getParameter("id").toString();
		String status = request.getParameter("status").toString();
		Business business = new Business();
	    
		business.setBusName(busName);
		business.setBusLicense(busLicense);
		business.setBusAddress(busAddress);
		business.setId(id);
		business.setIsCheck(status);
		if(file.isEmpty() == false){
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("upload/");
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			business.setBusImg(fileName);
		
		}
		
		
		boolean flag = businessService.updateBusiness(business);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	@RequestMapping(value="/selGoods",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoods(){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selAllGoods();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value = "/selGoodsById",method=RequestMethod.GET)
	public ReturnInfo<Goods> selGoodsById(String id){
		ReturnInfo<Goods> ret = new ReturnInfo<Goods>();
		Goods goods = goodsService.selGoodsById(id);
		if(goods != null){
			ret.setData(goods);
		}
		return ret;
		
	}
	@RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
	public ReturnInfo<String> updateGoods(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		String goodsName = request.getParameter("goodsName").toString();
		String goodsPlace = request.getParameter("goodsPlace").toString();
		String goodsPrice = request.getParameter("goodsPrice").toString();
		String id = request.getParameter("id").toString();
		
		Goods goods = new Goods();
		goods.setGoodsName(goodsName);
		goods.setGoodsPlace(goodsPlace);
		goods.setGoodsPrice(goodsPrice);
		goods.setId(id);
		if(file.isEmpty() == false){
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("upload/");
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			goods.setGoodsImg(fileName);
		
		}
		
		
		boolean flag = goodsService.updateGoods(goods);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value = "/delGoods",method = RequestMethod.POST)
	public ReturnInfo<Business> delGoods(String id){
		ReturnInfo<Business> ret = new ReturnInfo<Business>();
		boolean flag = goodsService.delGoods(id);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
}
