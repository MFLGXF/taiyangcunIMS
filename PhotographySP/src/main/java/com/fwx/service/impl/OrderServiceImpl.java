package com.fwx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.CardUtils;
import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.dao.OrderMapper;
import com.fwx.domain.Member;
import com.fwx.domain.Order;
import com.fwx.service.IorderService;

@Service
public class OrderServiceImpl implements IorderService {


	@Autowired
	private OrderMapper memberMapper;

	@Override
	public Boolean insert(Order member) throws Exception {

		/*生成唯一id*/
		member.setId(UUIDUtils.getUuid32());

		System.out.println("获取所有的数据："+member.toString());

		List<Order> disList = memberMapper.selectOrderByName(member);

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
	public PageInfo<Order> selectAll(Integer pageNumber, Integer pageSize, String username) {

		PageInfo<Order> page = new PageInfo<>();

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

		List<Order> result = memberMapper.selectList(queryMap);

		for(Order data:result){
			//System.out.println(data.getMemberLevel());
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
	public Boolean update(Order discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer listMemberByDiscountId(String id) {

		return memberMapper.selectMemberByDiscountId(id);
	}

}
