package com.fwx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwx.common.PageInfo;
import com.fwx.common.UUIDUtils;
import com.fwx.controller.ProductCategoryController;
import com.fwx.dao.ProductCategoryMapper;
import com.fwx.dao.ProductMapper;
import com.fwx.domain.Product;
import com.fwx.domain.ProductCategory;
import com.fwx.service.IproductService;

import ch.qos.logback.classic.Logger;

@Service
public class ProductServiceImpl implements IproductService {

	Logger log = (Logger) LoggerFactory.getLogger(ProductCategoryController.class);


	@Autowired
	private ProductMapper productorMapper;


	@Override
	public Boolean insert(Product pcData) {

		pcData.setId(UUIDUtils.getUuid32());
		pcData.setDelete_flag(0);

		/*首先需要检查是否有同名的产品类型存在*/
		List<Product> list = productorMapper.selectByName(pcData);
		if(list.size() > 0){
			return false;
		}
		Integer ret = productorMapper.insert(pcData);

		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Product> selectAll(Integer pageNumber, Integer pageSize, String pName) {

		PageInfo<Product> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("pName", pName);

		Integer count = productorMapper.selectCount(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+count);

		page.setTotalRow(count);
		page.setPageSize(pageSize);
		/*需要计算当前的页数和总页数*/
		page.setPageNumber(pageNumber);
		int totalPageNum = count%pageSize;
		int totalPage = count/pageSize;
		if(totalPageNum != 0){
			totalPage++;
		}
		page.setTotalPage(totalPage);
		page.setTotalPage(2);

		if(pageNumber <= 0){
			pageNumber = 1;
		}

		int start = (pageNumber*pageSize)-pageSize;
		int end = (pageNumber*pageSize);
		if(start <= 0){
			start = 0;
		}

		queryMap.put("start", start);
		queryMap.put("end", end);

		List<Product> result = productorMapper.selectList(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+result.toString());

		page.setList(result);
		return page;

	}

	@Override
	public Boolean delete(String id) {

		Integer ret = productorMapper.delete(id);
		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(Product discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Product> list() {

		PageInfo<Product> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("cardTypeName", "");


		queryMap.put("start", -1);
		queryMap.put("end", -1);

		List<Product> result = productorMapper.selectList(queryMap);
		page.setList(result);
		return page;
	}


}
