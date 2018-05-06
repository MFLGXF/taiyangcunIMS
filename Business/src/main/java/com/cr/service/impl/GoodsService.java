package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Goods;

public interface GoodsService {
	public boolean addProduce(Goods good);
	public List<Goods> selGoodsLimit();
	public List<Goods> selGoods();
	public List<Goods> selAllGoods();
	public Goods selGoodsById(String id);
}
