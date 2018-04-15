package com.fwx.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.Member;
import com.fwx.domain.MemberDiscount;
import com.fwx.domain.ProductCategory;
import com.fwx.service.IproductcategoryService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/productcategory")
public class ProductCategoryController {

	Logger log = (Logger) LoggerFactory.getLogger(ProductCategoryController.class);

	@Autowired
	private IproductcategoryService pcService;
	/**
	 * 添加会员卡优惠信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<ProductCategory> add(ProductCategory pcData) throws Exception{
		ReturnInfo<ProductCategory> ret = new ReturnInfo<>();
		Boolean result = pcService.insert(pcData);
		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}
		return ret;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<ProductCategory> update(ProductCategory member){
		ReturnInfo<ProductCategory> ret = new ReturnInfo<>();

		Boolean result = pcService.update(member);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}



	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<ProductCategory>> dataGrid(
			Integer pageNumber,
			Integer pageSize,
			String pcName){

		ReturnInfo<PageInfo<ProductCategory>> result = new ReturnInfo<>();
		log.info("前端获取的数据username="+pcName);
		PageInfo<ProductCategory> memberData = pcService.selectAll(pageNumber,pageSize,
				pcName);

		log.info("获取折扣方案列表数据："+memberData.toString());

		result.setData(memberData);
		return result;
	}


	@RequestMapping("/list")
	@ResponseBody
	public ReturnInfo<PageInfo<ProductCategory>> list(){


		ReturnInfo<PageInfo<ProductCategory>> result = new ReturnInfo<>();
		PageInfo<ProductCategory> discountData = pcService.list();

		log.info("获取折扣方案列表数据："+discountData.toString()+",,,获取长度："+discountData.getList().size());

		result.setData(discountData);
		return result;
	}

	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ReturnInfo<String> deleteMember(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Boolean areaData = pcService.delete(id);

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
