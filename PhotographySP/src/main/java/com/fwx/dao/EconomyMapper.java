package com.fwx.dao;

import java.util.List;
import java.util.Map;

import com.fwx.domain.Economy;
import com.fwx.domain.Product;

public interface EconomyMapper {

	/*
	 * 根据类型查询相应的类型
	 */
	public List<Economy> selectByName(Economy member);
	
	/*
     * 根据类型查询相应的类型
     */
    public Economy selectById(String id);

	/*
	 * 添加优惠折扣信息
	 */
	public Integer insert(Economy pcData);

	/*
	 * 分页查询总数
	 */
	public Integer selectCount(Map<String, Object> queryMap);

	/*
	 * 获取过滤之后的列表
	 */
	public List<Economy> selectList(Map<String, Object> queryMap);

	/*
	 * 删除数据
	 */
	public Integer delete(String id);

	/*
	 * 根据pcName删除数据
	 */
	public Integer deleteByPcName(String pcName);

	/*
	 * 修改记录
	 */
	public Integer update(Economy economy);


}
