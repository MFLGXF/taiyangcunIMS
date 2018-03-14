package com.cr.domain;

/*
 * 资产管理相关属性
 */
public class Asset {

	/*
	 * id
	 */
	private String id;

	/*
	 * 资产编号
	 */
	private String assetNumber;

	/*
	 * 资产名称
	 */
	private String assetName;

	/*
	 * 使用者id
	 */
	private String personId;

	/*
	 * 使用人名称
	 */
	private String personName;

	/*
	 * 资产型号
	 */
	private String assetModel;

	/*
	 * 资产状态
	 */
	private Integer assetStatus;

	/*
	 * 资产类型
	 */
	private Integer assetClassify;

	/*
	 * 删除标记
	 */
	private Integer deleteFlag;

	/*
	 * 登记时间
	 */
	private String createTime;

	/*
	 * 变更时间
	 */
	private String changeTime;

	/*
	 * 资产价值
	 */
	private Integer assetValue;



	/*
	 * 更新标记
	 */
	private Integer updateFlag;


	public Integer getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(Integer assetValue) {
		this.assetValue = assetValue;
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

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
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

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public Integer getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(Integer assetStatus) {
		this.assetStatus = assetStatus;
	}

	public Integer getAssetClassify() {
		return assetClassify;
	}

	public void setAssetClassify(Integer assetClassify) {
		this.assetClassify = assetClassify;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", assetNumber=" + assetNumber + ", assetName=" + assetName + ", personId="
				+ personId + ", personName=" + personName + ", assetModel=" + assetModel + ", assetStatus="
				+ assetStatus + ", assetClassify=" + assetClassify + ", deleteFlag=" + deleteFlag + ", createTime="
				+ createTime + ", changeTime=" + changeTime + ", assetValue=" + assetValue + ", updateFlag="
				+ updateFlag + "]";
	}


}
