package com.fwx.service;

import java.util.List;

import com.fwx.domain.Clothes;
import com.fwx.vo.ClothesVO;

public interface IclothesService {
	public boolean addClothes(List<ClothesVO> list);
	public List<Clothes> selClothes();
}
