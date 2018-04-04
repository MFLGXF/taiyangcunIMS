package com.cr.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.common.UUIDUtils;
import com.cr.dao.AreaMapper;
import com.cr.domain.Area;

import ch.qos.logback.classic.Logger;
@Service
public class AreaServiceImpl implements IareaService{

	Logger log = (Logger) LoggerFactory.getLogger(AreaServiceImpl.class);

	/*
	 * 注入属性
	 */
	@Autowired
	private AreaMapper areaMapper;

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
			}
		}
		/*设置土地信息的id*/
		area.setId(UUIDUtils.getUuid32());
		area.setDeleteFlag(1);

		area.setCreateTime(createTime);

		log.info("包装完之后的area信息："+area.toString());

		/* 调用数据操作方法，将area保存到数据库中*/
		Integer result = areaMapper.insert(area);

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
	public List<Area> selectAll() {
		List<Area> result = areaMapper.selectList();
		log.info("获取的表中的数据："+result.toString());
		return result;
	}

	/*
	 * (删除对应 信息)
	 * @see com.cr.service.impl.IareaService#deleteArea(java.lang.String)
	 */
	@Override
	public Boolean deleteArea(String id) {
		Integer result = areaMapper.deleteArea(id);
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

		area.setAreaConfirm(2);
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

}
