package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Category;

public interface CategoryService {
	public List<Category> selCategory();
	public boolean delCategory(int id);
	public boolean addCategory(Category category);
}
