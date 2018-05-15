package com.cr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cr.common.PageInfo;
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
			if(goods.getContent() == null){
				goods.setContent("暂无详情");
			}
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
			for(int i=0 ; i<list.size() ; i++){
				if(list.get(i).getContent() == null){
					list.get(i).setContent("暂无详情");
				}
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 分页查询商品信息并进行展示
	 */
    @Override
    public PageInfo<Goods> dataGrid(String goodName, String categoryType, Integer pageNumber, Integer pageSize) {
        PageInfo<Goods> pageInfo = new PageInfo<>();
        Integer start = 0;
        Integer end = 0;
        if(pageNumber == 0 && pageSize == 3){
            start = 0;
            end = 3;
        }else if(pageNumber == 0 && pageSize == 10){
            start = (pageNumber) * pageSize;
            end = start + pageSize;
        }else{
            start = (pageNumber-1) * pageSize;
            end = start + pageSize;
        }
        Map<String,Object> queryMap = new HashMap<>();
        
        queryMap.put("goodName", goodName);
        queryMap.put("categoryType", categoryType);
        
        Integer count = goodsDao.selectCount(queryMap);
        
        queryMap.put("start", start);
        queryMap.put("end", end);
        List<Goods> list = goodsDao.findList(queryMap);
        pageInfo.setTotalRow(count);
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setPageSize(pageSize);
        pageInfo.setList(list);
        return pageInfo;
    }
    @Override
    public Goods findById(String productId) {
        return goodsDao.selectByPrimaryKey(productId);
    }
	
}
