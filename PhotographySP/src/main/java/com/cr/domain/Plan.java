package com.cr.domain;

import java.util.Date;

public class Plan {
    private String id;

    private String planName;

    private String planMessage;

    private Date createTime;

    private String delFlag;
    
    private String time;
    
    

    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanMessage() {
        return planMessage;
    }

    public void setPlanMessage(String planMessage) {
        this.planMessage = planMessage == null ? null : planMessage.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}