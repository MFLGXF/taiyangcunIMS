package com.cr.service.impl;

import java.util.List;

import com.cr.VO.CommentVO;
import com.cr.domain.Comment;

public interface CommentService {

    public boolean insert(Comment comment);

    public List<CommentVO> findListById(String goodsId);

	
}
