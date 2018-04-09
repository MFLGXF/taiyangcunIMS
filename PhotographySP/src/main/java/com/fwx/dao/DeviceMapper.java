package com.fwx.dao;

import com.fwx.domain.Device;
import com.fwx.domain.DeviceExample;
import com.fwx.vo.ClothesVO;
import com.fwx.vo.DeviceVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    int countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    
    List<Device> selDevice();
    
    int addDevice(List<DeviceVO> list);
}