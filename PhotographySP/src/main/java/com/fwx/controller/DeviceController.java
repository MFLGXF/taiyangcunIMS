package com.fwx.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fwx.common.FileUtils;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.Device;
import com.fwx.service.IdeviceService;
import com.fwx.vo.ClothesVO;
import com.fwx.vo.DeviceVO;
@RequestMapping("/device")
@RestController
public class DeviceController {
	@Autowired
	private IdeviceService deviceService;
	@RequestMapping(value="addDevice",method=RequestMethod.POST)
	public ReturnInfo<Device> addDevice(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<Device> ret = new ReturnInfo<Device>();
		if(file.isEmpty() == true){
			ret.setResult(203);
			return ret;
		}
		//以上传时间excel文件时间戳作为文件名
		String fileName =  new Date().getTime()+file.getOriginalFilename();
		//文件上传保存路径
		String filePath = request.getSession().getServletContext().getRealPath("excel/");
		try {
		    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
		        
		}
		ImportParams params = new ImportParams();
	    params.setTitleRows(1);
	    params.setHeadRows(1);
	    
	    List<DeviceVO> list = ExcelImportUtil.importExcel(
	       new File(filePath+fileName),
	       DeviceVO.class, params);
	    if(list.size() == 0){
	    	ret.setResult(202);
	    	return ret;
	    }
	    boolean flag = deviceService.addDevice(list);
	    if(flag == true){    	
	    	boolean delFlag = FileUtils.delete(filePath+fileName);
	    	if(delFlag == true){
	    		ret.setResult(200);
	    	}
	    }else{
	    	ret.setResult(201);
	    }
		return ret;
	}
	@RequestMapping(value="selDevice",method=RequestMethod.GET)
	public ReturnInfo<List<Device>> selDevice(){
		ReturnInfo<List<Device>> ret = new ReturnInfo<List<Device>>();
		List<Device> list = deviceService.selDevice();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	@RequestMapping(value="updateDevice",method=RequestMethod.POST)
	public ReturnInfo<String> updateDevice(String id,String status){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		Device device = new Device();
		if("正常".equals(status)){
			device.setDeviceStatus("维修中");
		}else if("维修中".equals(status)){
			device.setDeviceStatus("已报废");
		}else if("已报废".equals(status)){
			device.setDeviceStatus("正常");
		}
		device.setId(id);
		boolean flag = deviceService.updateDeviceStatus(device);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
	@RequestMapping(value="delDevice",method=RequestMethod.POST)
	public ReturnInfo<String> delDevice(String[] id){
		ReturnInfo<String> ret = new ReturnInfo<String>();
		boolean flag = deviceService.delDevice(id);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
}
