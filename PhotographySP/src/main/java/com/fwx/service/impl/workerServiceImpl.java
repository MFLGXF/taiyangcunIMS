package com.fwx.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fwx.dao.WorkerMapper;
import com.fwx.domain.Worker;
import com.fwx.service.IworkerService;
@Service
public class workerServiceImpl implements IworkerService {
	@Resource
	private WorkerMapper workerDao;
	@Override
	public List<Worker> selAll() {		
		List<Worker> list = workerDao.selAll();
		if(list.size()>0){
			return list;
		}else{
			List<Worker> list1 = new ArrayList<Worker>();
			return list1;
		}
	}
	@Override
	public List<Worker> selectAll() {
		List<Worker> list = workerDao.selectAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				String time = sdf.format(list.get(i).getJoinTime());
				
			}
			return list;
		}else{
			return null;
		}
		
	}
	@Override
	public boolean addWorker(Worker worker) {
		int flag = workerDao.insert(worker);
		if(flag>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean delWorker(String[] id) {
		int flag = workerDao.delWorker(id);
		if(flag > 0){
			return true;
		}
		return false;
	}
}
