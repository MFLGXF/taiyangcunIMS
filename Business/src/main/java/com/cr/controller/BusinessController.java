package com.cr.controller;

import java.util.Date;
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
import com.cr.common.UUIDUtils;
import com.cr.domain.Goods;
import com.cr.service.impl.GoodsService;

@RestController
@RequestMapping("/business")
public class BusinessController {
	@Resource
	private GoodsService goodsService;
	@RequestMapping(value="/addproduce",method=RequestMethod.POST)
	public ReturnInfo<Goods> addproduce(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<Goods> ret = new ReturnInfo<Goods>();
		String goodsName = request.getParameter("goodsName");
		String goodsAddress = request.getParameter("goodsAddress");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsType = request.getParameter("goodsType");
		
		if("".equals(goodsName) | "".equals(goodsAddress) | "".equals(goodsPrice) | "".equals(goodsType)){
			ret.setResult(201);
			return ret;
		}
		Goods goods = new Goods();
		goods.setId(UUIDUtils.getUuid32());
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsProducer(request.getSession().getAttribute("businessname").toString());
		goods.setGoodsPlace(goodsAddress);
		goods.setGoodsType(goodsType);
		goods.setCreateTime(new Date());
		goods.setDelFlag("0");
		if(file.isEmpty() == false){
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("goods/");
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			goods.setGoodsImg(fileName);
		}else{
			ret.setResult(202);
			return ret;
		}
		
		boolean flag = goodsService.addProduce(goods);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(500);
		}
		return ret;
	}
	
	@RequestMapping(value="/selGoodsLimit",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoodsLimit(){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selGoodsLimit();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value="/selGoods",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoods(){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selGoods();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	@RequestMapping(value="/selGoodsBusiness",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoodsBusiness(HttpServletRequest request){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selGoodsBusiness(request.getSession().getAttribute("businessname").toString());
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
}
