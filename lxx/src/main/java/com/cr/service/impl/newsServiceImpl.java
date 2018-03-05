package com.cr.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.dao.NewsMapper;
import com.cr.domain.News;

@Service
public class newsServiceImpl implements InewsService {
	@Autowired
	private NewsMapper newsDao;
	/**
	 * 首页-新闻
	 */
	@Override
	public List<News> selNews() {
		List<News> newsList = newsDao.selNews();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月-dd");
		if(newsList.size()>0){
			for(int i=0;i<newsList.size();i++){
				String createTime = sdf.format(newsList.get(i).getCreateTime());
				newsList.get(i).setTime(createTime);
				String month = createTime.substring(0,3);
				String day = createTime.substring(4);
				newsList.get(i).setMonth(month);
				newsList.get(i).setDay(day);
			}
			return newsList;
		}
		return null;
	}
	/**
	 * 添加新闻
	 */
	@Override
	public boolean addNews(News news) {
		int flag = newsDao.insert(news);
		if(flag > 0){
			return true;
		}
		return false;
	}

}
