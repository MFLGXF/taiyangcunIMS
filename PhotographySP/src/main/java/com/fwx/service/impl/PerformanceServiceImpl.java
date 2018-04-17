package com.fwx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.dao.PerformanceMapper;
import com.fwx.domain.Economy;
import com.fwx.domain.Member;
import com.fwx.service.IperformanceService;
import com.fwx.vo.PerformanceVO;

import ch.qos.logback.classic.Logger;

@Service
public class PerformanceServiceImpl implements IperformanceService {

	Logger log = (Logger) LoggerFactory.getLogger(PerformanceServiceImpl.class);


	@Autowired
	private PerformanceMapper performanceMapper;


	@Override
	public Boolean insert(PerformanceVO pcData) {

		pcData.setStaId(UUIDUtils.getUuid32());

		String[] workerIds = pcData.getWorkerName().split("&");

		pcData.setWorkerId(workerIds[0]);
		pcData.setWorkerName(workerIds[1]);

		/*首先需要检查是否有同名的产品类型存在*/
		List<PerformanceVO> list = performanceMapper.selectByName(pcData);
		if(list.size() > 0){
			return false;
		}
		Integer ret = performanceMapper.insert(pcData);

		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<PerformanceVO> selectAll(Integer pageNumber, Integer pageSize, String workerName) {

		PageInfo<PerformanceVO> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("workerName", workerName);

		Integer count = performanceMapper.selectCount(queryMap);

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

		List<PerformanceVO> result = performanceMapper.selectList(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+result.toString());

		page.setList(result);
		return page;


	}

	@Override
	public Boolean delete(String id) {

		Integer ret = performanceMapper.delete(id);
		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(String ids,String eId) {
		return null;

	}

	@Override
	public PageInfo<PerformanceVO> list() {

		PageInfo<PerformanceVO> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("cardTypeName", "");


		queryMap.put("start", -1);
		queryMap.put("end", -1);

		List<PerformanceVO> result = performanceMapper.selectList(queryMap);
		page.setList(result);
		return page;
	}


}
