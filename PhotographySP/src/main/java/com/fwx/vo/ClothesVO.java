package com.fwx.vo;

import java.io.Serializable;

import org.jeecgframework.poi.excel.annotation.Excel;

public class ClothesVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name="性别", isImportField = "true_st")
    private String sex;
	@Excel(name="类型", isImportField = "true_st")
    private String style;
	@Excel(name="尺码", isImportField = "true_st")
    private String size;
	@Excel(name="价格", isImportField = "true_st")
    private Integer price;
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
    
}
