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
import com.fwx.service.ImemberService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/member")
public class MemberController {

	Logger log = (Logger) LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private ImemberService memberService;
	/**
	 * 添加会员卡优惠信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<Member> add(Member member) throws Exception{
		ReturnInfo<Member> ret = new ReturnInfo<>();
		Boolean result = memberService.insert(member);
		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}


	@RequestMapping("/update")
	@ResponseBody
	public ReturnInfo<Member> update(Member member){
		ReturnInfo<Member> ret = new ReturnInfo<>();

		Boolean result = memberService.update(member);

		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}

		return ret;
	}



	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<Member>> dataGrid(
			Integer pageNumber,
			Integer pageSize,
			String username){

		ReturnInfo<PageInfo<Member>> result = new ReturnInfo<>();
		log.info("前端获取的数据username="+username);
		PageInfo<Member> memberData = memberService.selectAll(pageNumber,pageSize,
				username);

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

		Boolean areaData = memberService.deleteMember(id);

		log.info("获取需要删除的 id："+id);

		if(areaData){
			result.setResult(200);
			result.setMsg("删除成功");
		}else{
			result.setResult(202);
			result.setMsg("删除失败，当前方案还在使用！");
		}
		return result;
	}



	@RequestMapping("/listByDiscountId")
	@ResponseBody
	public ReturnInfo<String> listByDiscountId(String id){
		ReturnInfo<String> result = new ReturnInfo<>();

		Integer areaData = memberService.listMemberByDiscountId(id);

		log.info("获取需要的 id："+id);

		if(areaData == 0){
			result.setResult(200);
			result.setMsg("获取成功");
		}else{
			result.setResult(202);
			result.setMsg("获取失败，当前方案还在使用！");
		}
		return result;
	}

}
