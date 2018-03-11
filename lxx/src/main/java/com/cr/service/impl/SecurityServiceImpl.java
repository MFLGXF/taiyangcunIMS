package com.cr.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.common.PageInfo;
import com.cr.common.UUIDUtils;
import com.cr.dao.AreaMapper;
import com.cr.dao.SecurityMapper;
import com.cr.domain.Area;
import com.cr.domain.SecurityHouse;
import com.cr.vo.StaticDataVO;

import ch.qos.logback.classic.Logger;
@Service
public class SecurityServiceImpl implements IsecurityService{

	Logger log = (Logger) LoggerFactory.getLogger(SecurityServiceImpl.class);

	/*
	 * 注入属性
	 */
	@Autowired
	private AreaMapper areaMapper;

	@Autowired
	private SecurityMapper securityMapper;


	/*
	 * 获取安全信息列表
	 * @see com.cr.service.impl.IsecurityService#selectAll()
	 */
	@Override
	public PageInfo<SecurityHouse> selectAll(Integer pageNumber, Integer pageSize) {


		PageInfo<SecurityHouse> page = new PageInfo<>();

		log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();


		Integer count = securityMapper.selectCount(queryMap);
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

		log.info("area-service中获取到start="+start+",end="+end);

		List<SecurityHouse> result = securityMapper.selectList(queryMap);
		log.info("获取到土地相关数据："+result.toString());
		page.setList(result);
		return page;

	}

	/*
	 * (更新房屋安全数据)
	 * @see com.cr.service.impl.IsecurityService#updateSecurity(com.cr.domain.SecurityHouse)
	 */

	@Override
	public Integer updateSecurity(SecurityHouse securityData) {

		Integer updatesecurity = securityMapper.updateSecurityById(securityData);

		return updatesecurity;
	}


}
