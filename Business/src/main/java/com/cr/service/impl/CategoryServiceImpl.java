package com.cr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cr.dao.CategoryMapper;
import com.cr.domain.Category;
import com.cr.domain.CategoryExample;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryDao;
	@Override
	public List<Category> selCategory() {
		List<Category> list = categoryDao.selectByExample(new CategoryExample());
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public boolean delCategory(int id) {
		int flag = categoryDao.deleteByPrimaryKey(id);
		if(flag > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addCategory(Category category) {
		int flag = categoryDao.insertSelective(category);
		if(flag > 0){
			return true;
		}
		return false;
	}

}
