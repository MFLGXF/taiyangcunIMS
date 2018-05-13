package com.cr.domain;

public class Comment
{
    private Integer id;
    
    private String userImg;
    
    private String goodsId;
    
    private String replyId;
    
    private String replyName;
    
    private String beReplyId;
    
    private String beReplyName;
    
    private String browse;
    
    private String osname;
    
    private String content;
    
    private String time;
    
    private String address;
    
    private Integer deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
    
    

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getBeReplyId() {
        return beReplyId;
    }

    public void setBeReplyId(String beReplyId) {
        this.beReplyId = beReplyId;
    }

    public String getBeReplyName() {
        return beReplyName;
    }

    public void setBeReplyName(String beReplyName) {
        this.beReplyName = beReplyName;
    }
    
    

    public String getBrowse() {
        return browse;
    }

    public void setBrowse(String browse) {
        this.browse = browse;
    }

    public String getOsname() {
        return osname;
    }

    public void setOsname(String osname) {
        this.osname = osname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", userImg=" + userImg + ", goodsId=" + goodsId + ", replyId=" + replyId
                + ", replyName=" + replyName + ", beReplyId=" + beReplyId + ", beReplyName=" + beReplyName + ", browse="
                + browse + ", osname=" + osname + ", content=" + content + ", time=" + time + ", address=" + address
                + ", deleteFlag=" + deleteFlag + "]";
    }
    
    
    
    
}
