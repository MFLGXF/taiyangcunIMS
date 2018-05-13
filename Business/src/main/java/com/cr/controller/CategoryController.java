package com.cr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.ReturnInfo;
import com.cr.domain.Category;
import com.cr.service.impl.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	@RequestMapping(value="/selCategory",method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<Category>> selCategory(){
		ReturnInfo<List<Category>> ret = new ReturnInfo<List<Category>>();
		List<Category> list = categoryService.selCategory();
		if(list!=null){
			ret.setData(list);
		}
		return ret;
	}
	@RequestMapping(value = "/delCategory",method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<Category> delCategory(String id){
		ReturnInfo<Category> ret = new ReturnInfo<Category>();
		boolean flag = categoryService.delCategory(Integer.valueOf(id));
		if(flag == true){
			ret.setResult(200);
		}
		return ret;

	}
	@RequestMapping(value = "/addCategory",method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo<Category> addCategory(String categoryName){
		ReturnInfo<Category> ret = new ReturnInfo<Category>();
		Category category = new Category();
		category.setCategoryName(categoryName);
		boolean flag = categoryService.addCategory(category);
		if(flag == true){
			ret.setResult(200);
		}
		return ret;
	}
}
