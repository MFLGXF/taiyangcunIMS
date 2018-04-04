package com.fwx.service;

import com.fwx.common.PageInfo;
import com.fwx.domain.Photo;

public interface IphotoService {
	boolean addPhoto(Photo photo);
	PageInfo<Photo> selPhoto(Integer pageNumber, Integer pageSize,String type,String username);
	boolean delPhoto(String[] id,String filePath);
}
