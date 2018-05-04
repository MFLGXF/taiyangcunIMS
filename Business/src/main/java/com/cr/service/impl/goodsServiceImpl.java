package com.cr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cr.dao.GoodsMapper;
import com.cr.domain.Goods;
import com.cr.domain.GoodsExample;

@Service
public class goodsServiceImpl implements GoodsService {
	@Resource
	private GoodsMapper goodsDao;
	@Override
	public boolean addProduce(Goods good) {
		int flag = goodsDao.insert(good);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<Goods> selGoodsLimit() {
		List<Goods> list = goodsDao.selGoodsLimit();
		if(list.size()>0){
			return list;
		}
		return null;
	}
	@Override
	public List<Goods> selGoods() {
		List<Goods> list = goodsDao.selectByExample(new GoodsExample());
		if(list.size()>0){
			return list;
		}
		return null;
	}
	
}
