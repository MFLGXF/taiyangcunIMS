package com.cr.service.impl;

import java.util.List;

import com.cr.domain.News;

public interface InewsService {
	public List<News> selNews();
	public boolean addNews(News news);
}
