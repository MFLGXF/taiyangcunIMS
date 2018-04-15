package com.fwx.domain;

/**
 * 摄影拍摄服务平台中的产品相关类
 * @author mfl
 *
 */
public class Product {

	private String id;

	/*
	 * 产品名称
	 */
	private String pName;

	/*
	 * 是否是租用的
	 */
	private Integer isRent;

	/*
	 * 当前产品的价格
	 */
	private Integer pPrice;

	/*
	 * 当前产品所属类别
	 */
	private String pCategory;

	/*
	 * 产品描述
	 */
	private String discription;

	/*
	 * 删除标记
	 */
	private Integer delete_flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getIsRent() {
		return isRent;
	}

	public void setIsRent(Integer isRent) {
		this.isRent = isRent;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}



	public Integer getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.delete_flag = delete_flag;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pName=" + pName + ", isRent=" + isRent + ", pPrice=" + pPrice + ", pCategory="
				+ pCategory + ", delete_flag=" + delete_flag + "]";
	}

}
