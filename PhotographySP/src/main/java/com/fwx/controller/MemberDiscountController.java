package com.fwx.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.MemberDiscount;
import com.fwx.service.ImemberdiscountService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/memberdiscount")
public class MemberDiscountController {

	Logger log = (Logger) LoggerFactory.getLogger(MemberDiscountController.class);

	@Autowired
	private ImemberdiscountService discountService;
	/**
	 * 添加会员卡优惠信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<MemberDiscount> add(MemberDiscount discount){
		ReturnInfo<MemberDiscount> ret = new ReturnInfo<MemberDiscount>();

		Boolean result = discountService.insert(discount);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<MemberDiscount> update(MemberDiscount discount){
		ReturnInfo<MemberDiscount> ret = new ReturnInfo<MemberDiscount>();

		Boolean result = discountService.update(discount);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}



	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<MemberDiscount>> dataGrid(
			Integer pageNumber,
			Integer pageSize,
			String cardTypeName ){

		log.info("获取前端获取的分页数据pageNumber="+pageNumber+",pageSize="+pageSize);

		ReturnInfo<PageInfo<MemberDiscount>> result = new ReturnInfo<>();
		log.info("前端获取的数据areaConfirm="+cardTypeName);
		PageInfo<MemberDiscount> discountData = discountService.selectAll(pageNumber,pageSize,
				cardTypeName);

		log.info("获取折扣方案列表数据："+discountData.toString()+",,,获取长度："+discountData.getList().size());

		result.setData(discountData);
		return result;
	}

	@RequestMapping("/list")
	@ResponseBody
	public ReturnInfo<PageInfo<MemberDiscount>> list(){


		ReturnInfo<PageInfo<MemberDiscount>> result = new ReturnInfo<>();
		PageInfo<MemberDiscount> discountData = discountService.list();

		log.info("获取折扣方案列表数据："+discountData.toString()+",,,获取长度："+discountData.getList().size());

		result.setData(discountData);
		return result;
	}


	/*
	 * 删除折扣信息
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ReturnInfo<String> deleteDiscount(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Boolean areaData = discountService.deleteDiscount(id);

		log.info("获取需要删除的折扣信息id："+id);

		if(areaData){
			result.setResult(200);
			result.setMsg("删除成功");
		}else{
			result.setResult(202);
			result.setMsg("删除失败，当前方案还在使用！");
		}
		return result;
	}

}
