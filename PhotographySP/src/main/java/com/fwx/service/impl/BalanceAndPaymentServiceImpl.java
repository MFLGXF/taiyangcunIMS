package com.fwx.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.solr.common.util.DateUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.dao.BalanceAndPaymentMapper;
import com.fwx.domain.BalanceAndPayment;
import com.fwx.service.IbalanceAndPaymentService;
import com.fwx.vo.PerformanceVO;

import ch.qos.logback.classic.Logger;

@Service
public class BalanceAndPaymentServiceImpl implements IbalanceAndPaymentService {

	Logger log = (Logger) LoggerFactory.getLogger(BalanceAndPaymentServiceImpl.class);


	@Autowired
	private BalanceAndPaymentMapper balanceAndPaymentMapper;


	@Override
	public Boolean insert(BalanceAndPayment pcData) {

		pcData.setId(UUIDUtils.getUuid32());

		/*首先需要检查是否有同名的产品类型存在*/
		List<BalanceAndPayment> list = balanceAndPaymentMapper.selectByName(pcData);
		if(list.size() > 0){
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		pcData.setBpTime(format.format(new Date()));
		Integer ret = balanceAndPaymentMapper.insert(pcData);

		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<BalanceAndPayment> selectAll(Integer pageNumber, Integer pageSize, String workerName) {

		PageInfo<BalanceAndPayment> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("bpName", workerName);

		Integer count = balanceAndPaymentMapper.selectCount(queryMap);

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

		List<BalanceAndPayment> result = balanceAndPaymentMapper.selectList(queryMap);
		result.stream().forEach(it-> {
			try {
				it.setBpTime(DateFormatUtils.format(DateUtil.parseDate(it.getBpTime()),"yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		System.out.println("获取到后端歘出来的数据条数："+result.toString());

		page.setList(result);
		return page;


	}


}
