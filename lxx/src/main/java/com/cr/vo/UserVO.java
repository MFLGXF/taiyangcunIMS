package com.cr.vo;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

public class UserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name="姓名", isImportField = "true_st",width = 10)
	private String name;
	@Excel(name="身份证号", isImportField = "true_st",width = 10)
	private String idcard;
	@Excel(name="联系方式", isImportField = "true_st",width = 10)
    private String phone;
	@Excel(name="家庭住址", isImportField = "true_st",width = 10)
	private String address;
	@Excel(name="出生日期", isImportField = "true_st",width = 10)
	private Date birthday;
	@Excel(name="宅基地面积", isImportField = "true_st",width = 10)
	private Integer homestead;
	@Excel(name="耕地面积", isImportField = "true_st",width = 10)
	private Integer land;
	@Excel(name="担任职务", isImportField = "true_st",width = 10)
	private String role;
	@Excel(name="上传照片", isImportField = "true_st",width = 10)
	private String photo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getHomestead() {
		return homestead;
	}
	public void setHomestead(Integer homestead) {
		this.homestead = homestead;
	}
	public Integer getLand() {
		return land;
	}
	public void setLand(Integer land) {
		this.land = land;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	    
}
