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
public class AreaServiceImpl implements IareaService{

	Logger log = (Logger) LoggerFactory.getLogger(AreaServiceImpl.class);

	/*
	 * 注入属性
	 */
	@Autowired
	private AreaMapper areaMapper;

	@Autowired
	private SecurityMapper securityMapper;

	/*
	 * (将土地信息保存到数据库中)
	 * @see com.cr.service.impl.IareaService#saveArea(com.cr.domain.Area)
	 */
	@Override
	public Boolean saveArea(Area area) {
		/*
		 * 首先整理数据，将各项数据包装好
		 */
		area.setAreaConfirm(2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = format.format(new Date());
		if(area != null){
			String personData = area.getPersonId();
			String rentPersonData = area.getRentPersonId();
			if(personData != null && personData.contains("&")){
				area.setPersonId(personData.split("&")[0]);
				area.setPersonName(personData.split("&")[1]);
				area.setAreaConfirm(1);
			}
			if(rentPersonData != null && rentPersonData.contains("&")){
				area.setRentPersonId(rentPersonData.split("&")[0]);
				area.setRentPersonName(rentPersonData.split("&")[1]);
				area.setRentTime(createTime);
				area.setAreaRent(1);
			}else{
				area.setAreaRent(2);
			}
		}
		/*设置土地信息的id*/
		area.setId(UUIDUtils.getUuid32());
		area.setDeleteFlag(1);

		area.setCreateTime(createTime);

		log.info("包装完之后的area信息："+area.toString());

		/* 调用数据操作方法，将area保存到数据库中*/
		Integer result = areaMapper.insert(area);

		/*
		 * 如果添加的是宅基地的话就添加安全信息
		 */
		if(area.getAreaType() == 2){
			SecurityHouse house = new SecurityHouse();
			house.setId(UUIDUtils.getUuid32());
			house.setCreateTime(createTime);
			house.setHouseAddress(area.getAreaAddress());
			house.setPersonId(area.getPersonId());
			house.setPersonName(area.getPersonName());
			house.setSecurityConfirm(2);
			house.setIsSecurity(3);
			house.setDeleteFlag(1);
			house.setSecurityContent("");
			house.setAreaId(area.getId());
			securityMapper.insert(house);
		}


		/*如果结果为0表示添加失败*/
		if(result != 0){
			return true;
		}
		return false;
	}

	/*
	 * 获取土地信息列表
	 * @see com.cr.service.impl.IareaService#selectAll()
	 */
	@Override
	public PageInfo<Area> selectAll(Integer pageNumber, Integer pageSize, String areaAddress, String personId,
			String rentPersonId, Integer areaConfirm, Integer areaRent) {


		PageInfo<Area> page = new PageInfo<>();

		log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("areaAddress", areaAddress);
		queryMap.put("personId", personId);
		queryMap.put("rentPersonId", rentPersonId);
		queryMap.put("areaConfirm", areaConfirm);
		queryMap.put("areaRent", areaRent);

		Integer count = areaMapper.selectCount(queryMap);
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

		List<Area> result = areaMapper.selectList(queryMap);
		log.info("获取到土地相关数据："+result.toString());
		page.setList(result);
		return page;

	}

	/*
	 * (删除对应 信息)
	 * @see com.cr.service.impl.IareaService#deleteArea(java.lang.String)
	 */
	@Override
	public Boolean deleteArea(String id) {
		/*
		 * 先删除地区
		 */
		Integer result = areaMapper.deleteArea(id);

		Integer securityRet = securityMapper.deleteSecurity(id);
		if(result != 0){
			return true;
		}
		return false;
	}

	/*
	 * (根据id查询数据)
	 * @see com.cr.service.impl.IareaService#findAreaById(java.lang.String)
	 */
	@Override
	public Area findAreaById(String id) {
		return areaMapper.selectAreaById(id);
	}

	/*
	 * (更新土地数据)
	 * @see com.cr.service.impl.IareaService#updateAreaById(com.cr.domain.Area)
	 */
	@Override
	public Integer updateAreaById(Area area) {

		//area.setAreaConfirm(2);
		if(area != null){
			String personData = area.getPersonId();
			String rentPersonData = area.getRentPersonId();
			if(personData != null && personData.contains("&")){
				log.info("修改土地信息执行到这里面了么？");
				area.setPersonId(personData.split("&")[0]);
				area.setPersonName(personData.split("&")[1]);
				area.setAreaConfirm(1);
			}
			if(rentPersonData != null && rentPersonData.contains("&")){
				area.setRentPersonId(rentPersonData.split("&")[0]);
				area.setRentPersonName(rentPersonData.split("&")[1]);
				area.setAreaRent(1);
			}
		}
		/*设置土地信息的id*/
		area.setDeleteFlag(1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String updateTime = format.format(new Date());
		area.setUpdateTime(updateTime);
		log.info("包装完之后的area信息："+area.toString());
		return areaMapper.updateAreaById(area);
	}

	/*
	 * 根据标识统计数据
	 * (non-Javadoc)
	 * @see com.cr.service.impl.IareaService#findAreaByRecord(java.lang.String)
	 */
	@Override
	public List<StaticDataVO> findAreaByRecord(String record) {

		List<StaticDataVO> list = new ArrayList<>();
		/*
		 * 这边获取到的数据都是已确权或者是已承包的数据
		 */
		Map<String,Object> recordMap = new HashMap<>();
		recordMap.put("record", record);
		Integer dataNum = areaMapper.findAreaByRecord(recordMap);
		/*
		 * 设置查询条件
		 */
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("areaAddress", "");
		queryMap.put("personId", "");
		queryMap.put("rentPersonId", "");
		queryMap.put("areaConfirm", 0);
		queryMap.put("areaRent", 0);

		/*
		 * 查询总数据
		 */
		int count = areaMapper.selectCount(queryMap);

		StaticDataVO dataFirst = new StaticDataVO();
		StaticDataVO dataSecond = new StaticDataVO();
		if("confirm".equals(record)){
			dataFirst.setName("已确权");
			dataFirst.setValue(dataNum);
			dataSecond.setName("未确权");
			dataSecond.setValue(count-dataNum);

		}else{
			dataFirst.setName("已承包");
			dataFirst.setValue(dataNum);
			dataSecond.setName("未承包");
			dataSecond.setValue(count-dataNum);
		}
		list.add(dataFirst);
		list.add(dataSecond);
		return list;
	}

}
