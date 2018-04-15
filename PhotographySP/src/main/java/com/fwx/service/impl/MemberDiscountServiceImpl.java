package com.fwx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.controller.MemberDiscountController;
import com.fwx.dao.MemberDiscountMapper;
import com.fwx.domain.MemberDiscount;
import com.fwx.service.ImemberdiscountService;

import ch.qos.logback.classic.Logger;

@Service
public class MemberDiscountServiceImpl implements ImemberdiscountService {


	Logger log = (Logger) LoggerFactory.getLogger(MemberDiscountServiceImpl.class);

	@Autowired
	private MemberDiscountMapper discountMapper;

	@Override
	public Boolean insert(MemberDiscount discount) {

		/*生成唯一id*/
		discount.setId(UUIDUtils.getUuid32());
		/*查询当前会员卡折扣方案是否存在*/

		List<MemberDiscount> disList = discountMapper.selectDiscountByType(discount);

		/*如果已经存在就返回*/
		if(disList.size() > 0){
			return false;
		}
		Integer ret = discountMapper.insert(discount);

		if(ret <= 0){
			return false;
		}
		return true;
	}

	@Override
	public PageInfo<MemberDiscount> selectAll(Integer pageNumber, Integer pageSize, String cardTypeName) {
		PageInfo<MemberDiscount> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("cardTypeName", cardTypeName);

		Integer count = discountMapper.selectCount(queryMap);

		log.info("获取到的分页前总数为："+count);

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

		List<MemberDiscount> result = discountMapper.selectList(queryMap);
		page.setList(result);
		return page;

	}

	@Override
	public Boolean deleteDiscount(String id) {
		Integer result = discountMapper.delete(id);
		System.out.println("删除优惠折扣数据返回的id是："+id);
		System.out.println("删除优惠折扣数据返回的结果是："+result);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(MemberDiscount discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<MemberDiscount> list() {
		PageInfo<MemberDiscount> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("cardTypeName", "");


		queryMap.put("start", -1);
		queryMap.put("end", -1);

		List<MemberDiscount> result = discountMapper.selectList(queryMap);
		page.setList(result);
		return page;
	}

}
