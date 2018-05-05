package com.cr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cr.common.ReturnInfo;
import com.cr.domain.Business;
import com.cr.domain.Goods;
import com.cr.service.impl.BusinessService;
import com.cr.service.impl.GoodsService;

import io.undertow.attribute.RequestMethodAttribute;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private BusinessService businessService;
	
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
}
