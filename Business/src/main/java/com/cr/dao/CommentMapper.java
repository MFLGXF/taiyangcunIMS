package com.cr.dao;

import java.util.List;

import com.cr.domain.Comment;

public interface CommentMapper {

    public Integer insert(Comment comment);
    
    public List<Comment> findListById(String goodsId);

    public List<Comment> findListReply(Comment comment);
    
}