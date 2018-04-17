package com.fwx.vo;

/**
 * 员工业绩管理VO
 * @author mfl
 *
 */
public class PerformanceVO {

	private String staId;

	/*
	 * 员工id
	 */
	private String workerId;

	/*
	 * 员工姓名
	 */
	private String workerName;


	/*
	 * 绩效评分
	 */
	private Integer pRatingNum;

	/*
	 * 绩效内容
	 */
	private String pContent;

	/*
	 * 绩效时间
	 */
	private String pTime;

	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}



	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public Integer getpRatingNum() {
		return pRatingNum;
	}

	public void setpRatingNum(Integer pRatingNum) {
		this.pRatingNum = pRatingNum;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	@Override
	public String toString() {
		return "PerformanceVO [staId=" + staId + ", workerId=" + workerId + ", workerName=" + workerName
				+ ", pRatingNum=" + pRatingNum + ", pContent=" + pContent + ", pTime=" + pTime + "]";
	}


}
