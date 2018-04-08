package com.fwx.dao;

import com.fwx.domain.Worker;
import com.fwx.domain.WorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WorkerMapper {
    int countByExample(WorkerExample example);

    int deleteByExample(WorkerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Worker record);

    int insertSelective(Worker record);

    List<Worker> selectByExample(WorkerExample example);

    Worker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
    @Select("SELECT worker_name as workerName,worker_idcard as workerIdcard,worker_phone as workerPhone,join_time as joinTime,wages,ava_flag as avaFlag,create_time as createTime FROM `worker` where del_flag!=1  and worker_post = '维修工人' ORDER BY worker_name")
    List<Worker> selAll();
    @Select("SELECT id,worker_name as workerName,worker_idcard as workerIdcard,worker_phone as workerPhone,join_time as joinTime,worker_bank_card as workerBankCard,worker_post as workerPost ,wages,ava_flag as avaFlag,create_time as createTime,photo FROM `worker` where del_flag!=1 ORDER BY wages desc")
    List<Worker> selectAll();
    
    int delWorker(String[] id);
    
    List<Worker> searchWorker(String name);
}