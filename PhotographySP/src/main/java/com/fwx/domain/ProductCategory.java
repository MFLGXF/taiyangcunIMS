package com.fwx.domain;

/**
 * 产品类别
 * @author mfl
 *
 */
public class ProductCategory {

	private String id;

	/*
	 * 类型名称
	 */
	private String pcName;

	/*
	 * 产品类型描述
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

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public Integer getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.delete_flag = delete_flag;
	}



	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", pcName=" + pcName + ", discription=" + discription + ", delete_flag="
				+ delete_flag + "]";
	}

}
