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
import com.fwx.domain.MemberDiscount;
import com.fwx.domain.ProductCategory;
import com.fwx.service.IproductcategoryService;

import ch.qos.logback.classic.Logger;

@Service
public class ProductCategoryServiceImpl implements IproductcategoryService {

	Logger log = (Logger) LoggerFactory.getLogger(ProductCategoryController.class);

	@Autowired
	private ProductCategoryMapper pcMapper;

	@Autowired
	private ProductMapper productorMapper;


	@Override
	public Boolean insert(ProductCategory pcData) {

		pcData.setId(UUIDUtils.getUuid32());
		pcData.setDelete_flag(0);

		/*首先需要检查是否有同名的产品类型存在*/
		List<ProductCategory> list = pcMapper.selectByName(pcData.getPcName());
		if(list.size() > 0){
			return false;
		}
		Integer ret = pcMapper.insert(pcData);

		if(ret > 0){
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<ProductCategory> selectAll(Integer pageNumber, Integer pageSize, String pcName) {

		PageInfo<ProductCategory> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("pcName", pcName);

		Integer count = pcMapper.selectCount(queryMap);

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

		List<ProductCategory> result = pcMapper.selectList(queryMap);

		System.out.println("获取到后端歘出来的数据条数："+result.toString());

		page.setList(result);
		return page;

	}

	@Override
	public Boolean delete(String id) {

		/*首先需要查看在该产品分类下面的产品有多少，然后一并删除*/
		ProductCategory pcData = pcMapper.selectProductCategoryById(id);
		log.info("获取到该ID对应的数据："+pcData.toString());
		if(pcData != null){
			Integer retProduct = productorMapper.deleteByPcName(pcData.getPcName());

			log.info("获取到使用产品分类名称删除的返回值："+retProduct);
			/*如果产品表中数据删除成功的话就将产品分类列表中的数据删除*/
			//if(retProduct > 0){
				log.info("开始删除对应的产品分类数据");
				Integer ret = pcMapper.delete(id);
				if(ret > 0){
					return true;
				}
			//}
		}
		return false;
	}

	@Override
	public Boolean update(ProductCategory discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<ProductCategory> list() {

		PageInfo<ProductCategory> page = new PageInfo<>();

		//log.info("获取到pageNumber和pageSize的值为：pageNumber="+pageNumber+",pageSize="+pageSize);

		/*首先查询当前有多少条数据*/
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("cardTypeName", "");


		queryMap.put("start", -1);
		queryMap.put("end", -1);

		List<ProductCategory> result = pcMapper.selectList(queryMap);
		page.setList(result);
		return page;
	}


}
