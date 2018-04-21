package com.fwx.domain;

/**
 * 收支记录表
 * @author mfl
 *
 */
public class BalanceAndPayment {

	private String id;

	/*
	 * 收支名称
	 */
	private String bpName;

	/*
	 * 收支类型
	 */
	private String bpType;

	/*
	 * 收支时间
	 */
	private String bpTime;

	/*
	 * 收支金额
	 */
	private Integer bpCount;

	/*
	 * 售出标记
	 */
	private Integer delete_flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBpName() {
		return bpName;
	}

	public void setBpName(String bpName) {
		this.bpName = bpName;
	}

	public String getBpType() {
		return bpType;
	}

	public void setBpType(String bpType) {
		this.bpType = bpType;
	}

	public String getBpTime() {
		return bpTime;
	}

	public void setBpTime(String bpTime) {
		this.bpTime = bpTime;
	}

	public Integer getBpCount() {
		return bpCount;
	}

	public void setBpCount(Integer bpCount) {
		this.bpCount = bpCount;
	}

	public Integer getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.delete_flag = delete_flag;
	}

	@Override
	public String toString() {
		return "BalanceAndPayment [id=" + id + ", bpName=" + bpName + ", bpType=" + bpType + ", bpTime=" + bpTime
				+ ", bpCount=" + bpCount + ", delete_flag=" + delete_flag + "]";
	}

}
