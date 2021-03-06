package com.cr.dao;

import com.cr.domain.User;
import com.cr.domain.UserExample;
import com.cr.vo.UserCountVO;
import com.cr.vo.UserVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //登录模块，调用sql语句
    List<User> login(User user);
    //显示人口信息
    List<User> userMessage();
    //查看一个人的具体信息
    User selUserMessage(String id);
    //查看一个人的家庭信息
    List<User> selUserHome(@Param("id")String id, @Param("address")String address);
    //查出生人员
    List<UserCountVO> selBorn();
    //查死亡人员
    List<UserCountVO> selDeath();
    //查在住人员
    List<UserCountVO> selLive();
    //查离村人员
    List<UserCountVO> selStay();
    //查看领导
    List<User> leader();
    //查看该职位是否存在
    List<User> selLeader(@Param("id")String id,@Param("role")String role);
    //查户籍信息
    List<User> selHome();
    //查看一家是否有户主存在
    List<User> selHouseholder(@Param("id")String id,@Param("address")String address,@Param("householder")String householder);
    //批量上传
    int addUserBatch(List<UserVO> list);
    
    int insertUser(UserVO user);
    
    List<User> selUser(String name);
}