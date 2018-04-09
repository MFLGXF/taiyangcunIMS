package com.fwx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.UUIDUtils;
import com.fwx.dao.DeviceMapper;
import com.fwx.domain.Device;
import com.fwx.service.IdeviceService;
import com.fwx.vo.DeviceVO;
@Service
public class deviceServiceImpl implements IdeviceService {
	@Autowired
	private DeviceMapper deviceDao;
	@Override
	public List<Device> selDevice() {
		List<Device> list = deviceDao.selDevice();
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public boolean updateDeviceStatus(Device deivce) {
		int flag = deviceDao.updateByPrimaryKeySelective(deivce);
		if(flag > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delDevice(String[] id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDevice(List<DeviceVO> list) {
		for(int i=0;i<list.size();i++){
			list.get(i).setId(UUIDUtils.getUuid32());
			list.get(i).setDeviceStatus("正常");
		}
		int flag = deviceDao.addDevice(list);
		if(flag > 0){
			return true;
		}
		return false;
	}

}
