package com.fwx.vo;

import java.io.Serializable;

import org.jeecgframework.poi.excel.annotation.Excel;

public class DeviceVO implements Serializable {
	   private String id;
	   @Excel(name="设备名称", isImportField = "true_st")
	    private String deviceName;
	   @Excel(name="设备编号", isImportField = "true_st")
	    private String deviceNo;
	   
	    private String deviceStatus;
	   @Excel(name="设备价格", isImportField = "true_st")
	    private Integer devicePrice;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDeviceName() {
			return deviceName;
		}

		public void setDeviceName(String deviceName) {
			this.deviceName = deviceName;
		}

		public String getDeviceNo() {
			return deviceNo;
		}

		public void setDeviceNo(String deviceNo) {
			this.deviceNo = deviceNo;
		}

		public String getDeviceStatus() {
			return deviceStatus;
		}

		public void setDeviceStatus(String deviceStatus) {
			this.deviceStatus = deviceStatus;
		}

		public Integer getDevicePrice() {
			return devicePrice;
		}

		public void setDevicePrice(Integer devicePrice) {
			this.devicePrice = devicePrice;
		}
	    
}
