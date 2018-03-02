package com.cr.vo;

import java.io.Serializable;
import java.util.List;

import com.cr.domain.User;

public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String password;

	private String idcard;

	private String phone;

	private String address;

	private String birthday;

	private Integer homestead;

	private Integer land;

	private String role;

	private Integer delflag;

	private String createtime;
	    
	private String photo;
	
	private List<User> userList;
	
	private String status;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
