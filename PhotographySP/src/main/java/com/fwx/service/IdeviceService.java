package com.fwx.service;

import java.util.List;

import com.fwx.domain.Device;
import com.fwx.vo.DeviceVO;

public interface IdeviceService {
	public List<Device> selDevice();
	public boolean updateDeviceStatus(Device device);
	public boolean delDevice(String[] id);
	public boolean addDevice(List<DeviceVO> list);
}
