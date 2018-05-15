package com.cr.service.impl;

import java.util.List;

import com.cr.common.PageInfo;
import com.cr.domain.Goods;

public interface GoodsService {
	public boolean addProduce(Goods good);
	public List<Goods> selGoodsLimit();
	public List<Goods> selGoods();
	public List<Goods> selAllGoods();
	public Goods selGoodsById(String id);
	public boolean updateGoods(Goods goods);
	public boolean delGoods(String id);
	public List<Goods> selGoodsBusiness(String goodsProducer);
	/*分页查询商品信息*/
    public PageInfo<Goods> dataGrid(String goodName, String categoryType, Integer pageNumber, Integer pageSize);
    //查询相片详情
    public Goods findById(String productId);
}
