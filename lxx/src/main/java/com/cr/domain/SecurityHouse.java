package com.cr.domain;

/*
 * 房屋安全相关信息
 */
public class SecurityHouse {

	/*
	 * id
	 */
	private String id;

	/*
	 * 区域id
	 */
	private String areaId;

	/*
	 * 房屋地址
	 */
	private String houseAddress;

	/*
	 * 是否有安全问题
	 */
	private Integer securityConfirm;

	/*
	 * 安全问题描述
	 */
	private String securityContent;

	/*
	 * 关联人员id
	 */
	private String personId;

	/*
	 * 关联人员名称
	 */
	private String personName;

	/*
	 * 创建时间
	 */
	private String createTime;

	/*
	 * 是否有安全问题
	 */
	private Integer isSecurity;

	/*
	 * 删除标记
	 */
	private Integer deleteFlag;











	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getIsSecurity() {
		return isSecurity;
	}

	public void setIsSecurity(Integer isSecurity) {
		this.isSecurity = isSecurity;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Integer getSecurityConfirm() {
		return securityConfirm;
	}

	public void setSecurityConfirm(Integer securityConfirm) {
		this.securityConfirm = securityConfirm;
	}

	public String getSecurityContent() {
		return securityContent;
	}

	public void setSecurityContent(String securityContent) {
		this.securityContent = securityContent;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	@Override
	public String toString() {
		return "SecurityHouse [id=" + id + ", areaId=" + areaId + ", houseAddress=" + houseAddress
				+ ", securityConfirm=" + securityConfirm + ", securityContent=" + securityContent + ", personId="
				+ personId + ", personName=" + personName + ", createTime=" + createTime + ", isSecurity=" + isSecurity
				+ ", deleteFlag=" + deleteFlag + "]";
	}





}
