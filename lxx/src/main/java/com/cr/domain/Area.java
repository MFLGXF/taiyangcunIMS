package com.cr.domain;

import java.util.Date;

public class Area {

	/*
	 * id
	 */
	private String id;

	/*
	 * 地址
	 */
	private String areaAddress;

	/*
	 * 土地类型
	 */
	private Integer areaType;

	/*
	 * 关联人员id
	 */
	private String personId;

	/*
	 * 耕地面积
	 */
	private Integer areaLandSize;

	/*
	 * 关联人员名称
	 */
	private String personName;

	/*
	 * 是否被确认
	 */
	private Integer areaConfirm;

	/*
	 * 创建时间
	 */
	private String createTime;

	/*
	 * 修改时间
	 */

	private String updateTime;

	/*
	 * 新添加一个属性，承包时间
	 */
	private String rentTime;

	/*
	 * 删除标记
	 */
	private Integer deleteFlag;

	/*
	 * 宅基地面积
	 */
	private Integer areaHouseSize;

	/*
	 * 承包人id
	 */
	private String rentPersonId;

	/*
	 * 承包人名称
	 */
	private String rentPersonName;

	/*
	 * 当前操作是否是更新
	 */
	private Integer updateFlag;

	/*
	 * 是否承包出去
	 */
	private Integer areaRent;





	public Integer getAreaRent() {
		return areaRent;
	}

	public void setAreaRent(Integer areaRent) {
		this.areaRent = areaRent;
	}

	public String getRentTime() {
		return rentTime;
	}

	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}

	public Integer getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(Integer updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaAddress() {
		return areaAddress;
	}

	public void setAreaAddress(String areaAddress) {
		this.areaAddress = areaAddress;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Integer getAreaLandSize() {
		return areaLandSize;
	}

	public void setAreaLandSize(Integer areaLandSize) {
		this.areaLandSize = areaLandSize;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getAreaConfirm() {
		return areaConfirm;
	}

	public void setAreaConfirm(Integer areaConfirm) {
		this.areaConfirm = areaConfirm;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getAreaHouseSize() {
		return areaHouseSize;
	}

	public void setAreaHouseSize(Integer areaHouseSize) {
		this.areaHouseSize = areaHouseSize;
	}

	public String getRentPersonId() {
		return rentPersonId;
	}

	public void setRentPersonId(String rentPersonId) {
		this.rentPersonId = rentPersonId;
	}

	public String getRentPersonName() {
		return rentPersonName;
	}

	public void setRentPersonName(String rentPersonName) {
		this.rentPersonName = rentPersonName;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", areaAddress=" + areaAddress + ", areaType=" + areaType + ", personId=" + personId
				+ ", areaLandSize=" + areaLandSize + ", personName=" + personName + ", areaConfirm=" + areaConfirm
				+ ", createTime=" + createTime + ", deleteFlag=" + deleteFlag + ", areaHouseSize=" + areaHouseSize
				+ ", rentPersonId=" + rentPersonId + ", rentPersonName=" + rentPersonName + "]";
	}



}
