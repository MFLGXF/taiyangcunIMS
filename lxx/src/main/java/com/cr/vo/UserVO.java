package com.cr.vo;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

public class UserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name="姓名", isImportField = "true_st")
	private String name;
	@Excel(name="身份证号", isImportField = "true_st")
	private String idcard;
	@Excel(name="性别", isImportField = "true_st")
	private String sex;
	@Excel(name="民族", isImportField = "true_st")
	private String nation;
	@Excel(name="职业", isImportField = "true_st")
	private String occupation;
	@Excel(name="教育程度", isImportField = "true_st")
	private String education;
	@Excel(name="婚姻状况", isImportField = "true_st")
	private String marriage;
	@Excel(name="担任职务", isImportField = "true_st")
	private String role;
	@Excel(name="联系方式", isImportField = "true_st")
	private String phone;
	@Excel(name="家庭住址", isImportField = "true_st")
	private String address;
	@Excel(name="出生日期", isImportField = "true_st")
	private Date birthday;
	@Excel(name="耕地面积", isImportField = "true_st")
	private String land;
	@Excel(name="宅基地面积", isImportField = "true_st")
	private String homestead;
	@Excel(name="是否为户主", isImportField = "true_st")
	private String householder;
	private String id;
	private String photo;
	private String status;
	private Integer delflag;
	private Date createtime;
	private String message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getHomestead() {
		return homestead;
	}
	public void setHomestead(String homestead) {
		this.homestead = homestead;
	}
	public String getHouseholder() {
		return householder;
	}
	public void setHouseholder(String householder) {
		this.householder = householder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	    
}
