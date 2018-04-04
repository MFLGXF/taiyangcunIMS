package com.fwx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.FileUtils;
import com.fwx.common.PageInfo;
import com.fwx.dao.PhotoMapper;
import com.fwx.domain.Photo;
import com.fwx.domain.PhotoExample;
import com.fwx.service.IphotoService;
@Service
public class photoServiceImpl implements IphotoService {
	@Autowired
	private PhotoMapper photoDao;
	@Override
	public PageInfo<Photo> selPhoto(Integer pageNumber, Integer pageSize, String type,String username) {
		PageInfo<Photo> page = new PageInfo<>();
		PhotoExample example = new PhotoExample();
		Integer count = photoDao.countByExample(example);
		page.setTotalRow(count);
		page.setPageSize(pageSize);
		Map<String,Object> queryMap = new HashMap<>();
		/*需要计算当前的页数和总页数*/
		page.setPageNumber(pageNumber);
		int totalPageNum = count%pageSize;
		int totalPage = count/pageSize;
		if(totalPageNum != 0){
			totalPage++;
		}
		page.setTotalPage(totalPage);

		if(pageNumber <= 0){
			pageNumber = 1;
		}

		int start = (pageNumber*pageSize)-pageSize;
		int end = (pageNumber*pageSize);
		if(start <= 0){
			start = 0;
		}
		if(type == null){
			queryMap.put("photoType", null);
		}else{
			queryMap.put("photoType", type);
		}
		if(username != null){
			queryMap.put("username", username);
		}
		queryMap.put("start", start);
		queryMap.put("end", end);
		List<Photo> result = photoDao.selectList(queryMap);
		
		page.setList(result);
		return page;
		
	}
	@Override
	public boolean addPhoto(Photo photo) {
		int flag = photoDao.insertSelective(photo);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean delPhoto(String[] id,String filePath) {
		List<Photo> photoList = photoDao.selPhotoByID(id);
		int flag = photoDao.delPhoto(id);
		if(flag>0){
			if(photoList.size()>0){
				for(int i=0;i<photoList.size();i++){
					FileUtils.delete(filePath+photoList.get(i).getPhotoName());
				}
			}
			return true;
		}
		return false;
	}

}
