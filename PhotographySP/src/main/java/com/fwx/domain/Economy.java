package com.fwx.domain;
/**
 * 套系model
 * @author mfl
 *
 */
public class Economy {

	private String id;

	/*
	 * 套系名称
	 */
	private String eName;

	/*
	 * 摄影师数量
	 */
	private Integer ePhotographyer;

	/*
	 * 是否需要造型师
	 */
	private Integer eModelling;
	
	/*
	 * 套系价格
	 */
	private Integer ePrice;

	/*
	 * 布景选择
	 */
	private String eLocation;

	/*
	 * 套系描述
	 */
	private String eDiscription;

	/*
	 * 关联的产品id串
	 */
	private String productIds;

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

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Integer getePhotographyer() {
		return ePhotographyer;
	}

	public void setePhotographyer(Integer ePhotographyer) {
		this.ePhotographyer = ePhotographyer;
	}

	public Integer geteModelling() {
		return eModelling;
	}

	public void seteModelling(Integer eModelling) {
		this.eModelling = eModelling;
	}

	public String geteLocation() {
		return eLocation;
	}

	public void seteLocation(String eLocation) {
		this.eLocation = eLocation;
	}

	public String geteDiscription() {
		return eDiscription;
	}

	public void seteDiscription(String eDiscription) {
		this.eDiscription = eDiscription;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public Integer getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.delete_flag = delete_flag;
	}
	
	

	public Integer getePrice() {
        return ePrice;
    }

    public void setePrice(Integer ePrice) {
        this.ePrice = ePrice;
    }

    @Override
	public String toString() {
		return "Economy [id=" + id + ", eName=" + eName + ", ePhotographyer=" + ePhotographyer + ", eModelling="
				+ eModelling + ", eLocation=" + eLocation + ", eDiscription=" + eDiscription + ", productIds="
				+ productIds + ", delete_flag=" + delete_flag + "]";
	}

}
