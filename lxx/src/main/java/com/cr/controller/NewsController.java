package com.cr.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cr.common.ReturnInfo;
import com.cr.common.UUIDUtils;
import com.cr.domain.News;
import com.cr.service.impl.InewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private InewsService newsService;
	/**
	 * 首页-新闻
	 */
	@RequestMapping(value="selNews",method=RequestMethod.GET)
	@ResponseBody
	public ReturnInfo<List<News>> selNews(){
		ReturnInfo<List<News>> ret = new ReturnInfo<List<News>>();
		List<News> newsList = newsService.selNews();
		if(newsList != null){
			ret.setData(newsList);
		}
		return ret;
	}
	/**
	 * 信息管理-计划管理-添加新闻
	 * @throws ParseException 
	 */
	@RequestMapping("/addNews")
	@ResponseBody
	public ReturnInfo<News> addPlan(String newsName,String newsMessage) throws ParseException{
		ReturnInfo<News> ret = new ReturnInfo<News>();
	     
		News news = new News();
		news.setId(UUIDUtils.getUuid32());
		news.setNewsName(newsName);
		news.setNewsMessage(newsMessage);
		news.setCreateTime(new Date());
		boolean flag = newsService.addNews(news);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(201);
		}
		return ret;
	}
}
