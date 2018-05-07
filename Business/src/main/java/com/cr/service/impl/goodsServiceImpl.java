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
		List<Goods> list = goodsDao.selGoods();
		if(list.size()>0){
			return list;
		}
		return null;
	}
	@Override
	public List<Goods> selAllGoods() {
		List<Goods> list = goodsDao.selectByExample(new GoodsExample());
		if(list.size()>0){
			return list;
		}
		return null;
	}
	@Override
	public Goods selGoodsById(String id) {
		Goods goods = goodsDao.selectByPrimaryKey(id);
		if(goods != null){
			return goods;
		}
		return null;
	}
	@Override
	public boolean updateGoods(Goods goods) {
		int flag = goodsDao.updateByPrimaryKeySelective(goods);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public boolean delGoods(String id) {
		int flag = goodsDao.deleteByPrimaryKey(id);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<Goods> selGoodsBusiness(String goodsProducer) {
		List<Goods> list = goodsDao.selGoodsBusiness(goodsProducer);
		if(list.size()>0){
			return list;
		}
		return null;
	}
	
}
