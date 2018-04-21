package com.fwx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.CardUtils;
import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.dao.MemberMapper;
import com.fwx.domain.Member;
import com.fwx.service.ImemberService;

@Service
public class MemberServiceImpl implements ImemberService {


	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Boolean insert(Member member) throws Exception {

		/*生成唯一id*/
		member.setId(UUIDUtils.getUuid32());
		/*查询当前会员卡是否存在*/
		member.setAge(CardUtils.getCarInfo(member.getCardNumber()).get("age"));
		member.setSex(CardUtils.getCarInfo(member.getCardNumber()).get("sex"));
		String[] datas = member.getDiscountId().split("&");
		for(String key: datas){
			System.out.println(key);
		}
		member.setDiscountId(datas[0]);
		member.setMemberLevel(datas[1]);

		System.out.println("获取所有的数据："+member.toString());

		List<Member> disList = memberMapper.selectMemberByName(member);

		/*如果已经存在就返回*/
		if(disList.size() > 0){
			return false;
		}
		Integer ret = memberMapper.insert(member);

		if(ret <= 0){
			return false;
		}
		return true;
	}

	@Override
	public PageInfo<Member> selectAll(Integer pageNumber, Integer pageSize, String username) {

		PageInfo<Member> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("username", username);

		Integer count = memberMapper.selectCount(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+count);

		page.setTotalRow(count);
		page.setPageSize(pageSize);
		/*需要计算当前的页数和总页数*/
		page.setPageNumber(pageNumber);
		int totalPageNum = count%pageSize;
		int totalPage = count/pageSize;
		if(totalPageNum != 0){
			totalPage++;
		}
		page.setTotalPage(totalPage);
		page.setTotalPage(2);

		if(pageNumber <= 0){
			pageNumber = 1;
		}

		int start = (pageNumber*pageSize)-pageSize;
		int end = (pageNumber*pageSize);
		if(start <= 0){
			start = 0;
		}

		queryMap.put("start", start);
		queryMap.put("end", end);

		List<Member> result = memberMapper.selectList(queryMap);

		for(Member data:result){
			System.out.println(data.getMemberLevel());
		}

		System.out.println("获取到后端歘出来的数据条数："+result.toString());

		page.setList(result);
		return page;
	}

	@Override
	public Boolean deleteMember(String id) {
		Integer result = memberMapper.delete(id);
		if(result > 0 ){
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(Member discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer listMemberByDiscountId(String id) {

		return memberMapper.selectMemberByDiscountId(id);
	}

}
