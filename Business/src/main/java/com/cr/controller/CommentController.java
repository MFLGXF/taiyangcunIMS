package com.cr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cr.VO.CommentVO;
import com.cr.common.ReturnInfo;
import com.cr.domain.Comment;
import com.cr.service.impl.CommentService;
import com.cr.service.impl.LoginService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentService commentService;
	@Resource
	private LoginService LoginService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ReturnInfo<String> addComment(Comment comment){
	    ReturnInfo<String> result = new ReturnInfo<>();
	    
	    
	    System.out.println(comment.toString());
	    
	    boolean bool = commentService.insert(comment);
	    if(bool){
	        result.setMsg("添加成功");
	        result.setResult(200);
	    }else{
	        result.setMsg("添加失败");
	        result.setResult(201);
	    }
	    
	    return result;
	}
	
	@RequestMapping(value="/listbyid",method=RequestMethod.POST)
    public ReturnInfo<List<CommentVO>> listByGoodsId(String goodsId){
        ReturnInfo<List<CommentVO>> result = new ReturnInfo<>();
        //开始组装json返回的数据
        List<CommentVO> commentData = commentService.findListById(goodsId);
        
        if(commentData != null && commentData.size() > 0){
            result.setResult(200);
            result.setData(commentData);
        }else{
            result.setResult(201);
            result.setMsg("获取失败");
        }
        
        return result;
    }
	
}
