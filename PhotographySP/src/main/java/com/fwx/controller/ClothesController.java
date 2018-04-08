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
import com.fwx.domain.Clothes;
import com.fwx.service.IclothesService;
import com.fwx.vo.ClothesVO;

@RequestMapping("/clothes")
@RestController
public class ClothesController {
	@Autowired
	private IclothesService clothesService;
	@RequestMapping(value="/addClothes",method=RequestMethod.POST)
	public ReturnInfo<Clothes> addClothes(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
		ReturnInfo<Clothes> ret = new ReturnInfo<Clothes>();
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
	    
	    List<ClothesVO> list = ExcelImportUtil.importExcel(
	       new File(filePath+fileName),
	       ClothesVO.class, params);
	    if(list.size() == 0){
	    	ret.setResult(202);
	    	return ret;
	    }
	    boolean flag = clothesService.addClothes(list);
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
	
}
