package com.fwx.domain;

import java.util.Date;

public class Worker {
    private Integer id;

    private String workerName;

    private String workerIdcard;

    private String workerPost;

    private String workerPhone;

    private Date joinTime;

    private String wages;

    private String delFlag;

    private String avaFlag;

    private Date createTime;

    private String workerBankCard;

    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public String getWorkerIdcard() {
        return workerIdcard;
    }

    public void setWorkerIdcard(String workerIdcard) {
        this.workerIdcard = workerIdcard == null ? null : workerIdcard.trim();
    }

    public String getWorkerPost() {
        return workerPost;
    }

    public void setWorkerPost(String workerPost) {
        this.workerPost = workerPost == null ? null : workerPost.trim();
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone == null ? null : workerPhone.trim();
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages == null ? null : wages.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getAvaFlag() {
        return avaFlag;
    }

    public void setAvaFlag(String avaFlag) {
        this.avaFlag = avaFlag == null ? null : avaFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWorkerBankCard() {
        return workerBankCard;
    }

    public void setWorkerBankCard(String workerBankCard) {
        this.workerBankCard = workerBankCard == null ? null : workerBankCard.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}