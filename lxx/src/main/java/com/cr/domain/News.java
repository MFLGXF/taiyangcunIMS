package com.cr.domain;

import java.util.Date;

public class News {
    private String id;

    private String newsName;

    private String newsMessage;

    private Date createTime;
    
    private String month;
    
    private String day;
    
    private String time;
    
    public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

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

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName == null ? null : newsName.trim();
    }

    public String getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(String newsMessage) {
        this.newsMessage = newsMessage == null ? null : newsMessage.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}