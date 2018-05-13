package com.cr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cr.common.UUIDUtils;
import com.cr.dao.CommentMapper;
import com.cr.domain.Comment;
import com.cr.vo.CommentVO;
@Service
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentMapper commentDao;

    @Override
    public boolean insert(Comment comment) {
        comment.setReplyId(UUIDUtils.getUuid32());
        Integer flag = commentDao.insert(comment);
        
        if(flag > 0){
            return true;
        }        
        return false;
    }

    /*id : 2,
    userImg : "assets/img/img.jpg",
    replyName : "匿名",
    beReplyName : "",
    content : "到菜市场买菜，看到一个孩子在看摊，我问：“一只鸡多少钱？” 那孩子回答：“23。” 我又问：“两只鸡多少钱？” 孩子愣了一下，一时间没算过来，急中生智大吼一声：“一次只能买一只！”",
    time : "2017-10-17 11:42:53",
    address : "深圳",
    osname : "",
    browse : "谷歌",
    replyBody : [ {
        id : 3,
        userImg : "",
        replyName : "帅大叔",
        beReplyName : "匿名",
        content : "来啊，我们一起吃鸡",
        time : "2017-10-17 11:42:53",
        address : "",
        osname : "",
        browse : "谷歌"
    } ]*/
    
    @Override
    public List<CommentVO> findListById(String goodsId) {
        List<CommentVO> list = new ArrayList<>();
        List<Comment> commentList = commentDao.findListById(goodsId);
        
        if(!commentList.isEmpty()){
            for(Comment comment : commentList){
                CommentVO voData = new CommentVO();
                voData.setId(comment.getId());
                voData.setGoodsId(comment.getGoodsId());
                voData.setReplyId(comment.getReplyId());
                voData.setReplyName(comment.getReplyName());
                voData.setBeReplyId(comment.getBeReplyId());
                voData.setBeReplyName(comment.getBeReplyName());
                voData.setContent(comment.getContent());
                voData.setTime(comment.getTime());
                voData.setUserImg(comment.getUserImg());
                voData.setBrowse(comment.getBrowse());
                voData.setOsname(comment.getOsname());
                //获取回复的列表
                //if(comment.getBeReplyName() != null && comment.getBeReplyId() != null){
                List<Comment> listData = commentDao.findListReply(comment);
                voData.setReplyBody(listData);
                if(listData == null){
                    voData.setReplyBody(new ArrayList<>());
                }
                
                list.add(voData);
            }
        }
        
        
        return list;
    }
	

}
