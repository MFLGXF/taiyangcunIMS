package com.fwx.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.Product;
import com.fwx.service.IproductService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/product")
public class ProductController {

	Logger log = (Logger) LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IproductService productService;
	/**
	 * 添加会员卡优惠信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<Product> add(Product pcData) throws Exception{
		ReturnInfo<Product> ret = new ReturnInfo<>();
		Boolean result = productService.insert(pcData);
		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}
		return ret;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<Product> update(Product member){
		ReturnInfo<Product> ret = new ReturnInfo<>();

		Boolean result = productService.update(member);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}



	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<Product>> dataGrid(
			Integer pageNumber,
			Integer pageSize,
			String pName){

		ReturnInfo<PageInfo<Product>> result = new ReturnInfo<>();
		log.info("前端获取的数据username="+pName);
		PageInfo<Product> memberData = productService.selectAll(pageNumber,pageSize,
				pName);

		log.info("获取折扣方案列表数据："+memberData.toString());

		result.setData(memberData);
		return result;
	}

	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ReturnInfo<String> deleteMember(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Boolean areaData = productService.delete(id);

		log.info("获取需要删除的 id："+id);

		if(areaData){
			result.setResult(200);
			result.setMsg("删除成功");
		}else{
			result.setResult(202);
			result.setMsg("删除失败，当前分类还在使用！");
		}
		return result;
	}





}
