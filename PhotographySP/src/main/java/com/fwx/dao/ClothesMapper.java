package com.fwx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fwx.domain.Clothes;
import com.fwx.domain.ClothesExample;
import com.fwx.vo.ClothesVO;

public interface ClothesMapper {
    int countByExample(ClothesExample example);

    int deleteByExample(ClothesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Clothes record);

    int insertSelective(Clothes record);

    List<Clothes> selectByExample(ClothesExample example);

    Clothes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Clothes record, @Param("example") ClothesExample example);

    int updateByExample(@Param("record") Clothes record, @Param("example") ClothesExample example);

    int updateByPrimaryKeySelective(Clothes record);

    int updateByPrimaryKey(Clothes record);
    int addClothes(List<ClothesVO> list);
    List<Clothes> selClothes();
}