package com.fwx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.UUIDUtils;
import com.fwx.dao.ClothesMapper;
import com.fwx.domain.Clothes;
import com.fwx.service.IclothesService;
import com.fwx.vo.ClothesVO;
@Service
public class clothesServiceImpl implements IclothesService {
	@Autowired
	private ClothesMapper clothesDao;
	@Override
	public boolean addClothes(List<ClothesVO> list) {
		for(int i=0;i<list.size();i++){
			list.get(i).setId(UUIDUtils.getUuid32());
		}
		int flag = clothesDao.addClothes(list);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<Clothes> selClothes() {
		List<Clothes> list = clothesDao.selClothes();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getUsename()==null){
					list.get(i).setUsename("暂无");
				}
			}
			return list;
		}
		return null;
	}

}
