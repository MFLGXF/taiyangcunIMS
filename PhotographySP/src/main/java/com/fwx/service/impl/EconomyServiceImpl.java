package com.fwx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.dao.EconomyMapper;
import com.fwx.domain.Economy;
import com.fwx.domain.Product;
import com.fwx.service.IeconomyService;

import ch.qos.logback.classic.Logger;

@Service
public class EconomyServiceImpl implements IeconomyService {

	Logger log = (Logger) LoggerFactory.getLogger(EconomyServiceImpl.class);


	@Autowired
	private EconomyMapper economyMapper;


	@Override
	public Boolean insert(Economy pcData) {

		pcData.setId(UUIDUtils.getUuid32());
		pcData.setDelete_flag(0);

		/*首先需要检查是否有同名的产品类型存在*/
		List<Economy> list = economyMapper.selectByName(pcData);
		if(list.size() > 0){
			return false;
		}
		Integer ret = economyMapper.insert(pcData);

		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Economy> selectAll(String eName) {

		PageInfo<Economy> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("eName", eName);

		Integer count = economyMapper.selectCount(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+count);

		page.setTotalRow(count);




		queryMap.put("start", -1);
		queryMap.put("end", -1);

		List<Economy> result = economyMapper.selectList(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+result.toString());

		page.setList(result);
		return page;

	}

	@Override
	public Boolean delete(String id) {

		Integer ret = economyMapper.delete(id);
		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(String ids,String eId) {

		Economy economy = new Economy();
		economy.setId(eId);
		economy.setProductIds(ids);
		Integer result = economyMapper.update(economy);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Economy> list() {

		PageInfo<Economy> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("cardTypeName", "");


		queryMap.put("start", -1);
		queryMap.put("end", -1);

		List<Economy> result = economyMapper.selectList(queryMap);
		page.setList(result);
		return page;
	}


}
