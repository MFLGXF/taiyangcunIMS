package com.cr.vo;

import java.util.List;

import com.cr.domain.Comment;

public class CommentVO
{
private Integer id;
    
    private String userImg;
    
    private String goodsId;
    
    private String replyId;
    
    private String replyName;
    
    private String beReplyId;
    
    private String beReplyName;
    
    private String content;
    
    private String browse;
    
    private String osname;
    
    private String time;
    
    private String address;
    
    private List<Comment> replyBody;

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

    public List<Comment> getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(List<Comment> replyBody) {
        this.replyBody = replyBody;
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

    @Override
    public String toString() {
        return "CommentVO [id=" + id + ", userImg=" + userImg + ", goodsId=" + goodsId + ", replyId=" + replyId
                + ", replyName=" + replyName + ", beReplyId=" + beReplyId + ", beReplyName=" + beReplyName
                + ", content=" + content + ", browse=" + browse + ", osname=" + osname + ", time=" + time + ", address="
                + address + ", replyBody=" + replyBody + "]";
    }
    
    
    
    
}
