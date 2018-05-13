package com.cr.service.impl;

import java.util.List;

import com.cr.domain.Comment;
import com.cr.vo.CommentVO;

public interface CommentService {

    public boolean insert(Comment comment);

    public List<CommentVO> findListById(String goodsId);

	
}
