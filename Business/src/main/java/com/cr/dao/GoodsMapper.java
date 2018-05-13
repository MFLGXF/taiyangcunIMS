package com.cr.dao;

import com.cr.domain.Goods;
import com.cr.domain.GoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
    
    List<Goods> selGoodsLimit();
    List<Goods> selGoods();
    List<Goods> selGoodsBusiness(String goodsProducer);

    /**
     * 分页查询数据
     *  @param queryMap
     *  @return    
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    List<Goods> findList(Map<String, Object> queryMap);
    /*
     * 查询数量
     */
    Integer selectCount(Map<String, Object> queryMap);
}