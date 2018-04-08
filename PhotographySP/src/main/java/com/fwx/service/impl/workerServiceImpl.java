package com.fwx.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fwx.dao.CustomerMapper;
import com.fwx.dao.WorkerMapper;
import com.fwx.domain.Customer;
import com.fwx.domain.Worker;
import com.fwx.service.IworkerService;
@Service
public class workerServiceImpl implements IworkerService {
	@Resource
	private WorkerMapper workerDao;
	@Resource
	private CustomerMapper customerDao;
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
				list.get(i).setTime(time);
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
	@Override
	public boolean addCustomer(Customer customer) {
		int flag = customerDao.insert(customer);
		if(flag > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<Customer> selCustomer() {
		List<Customer> list = customerDao.selCustomer();
		if(list.size()>0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++){
				list.get(i).setTime(sdf.format(list.get(i).getCreateTime()));
			}
			return list;
		}
		return null;
	}
	@Override
	public List<Customer> searchCustomer(String name) {
		List<Customer> list = customerDao.searchCustomer(name);
		if(list.size()>0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++){
				list.get(i).setTime(sdf.format(list.get(i).getCreateTime()));
			}
			return list;
		}
		return null;
	}
	@Override
	public List<Worker> searchWorker(String name) {
		List<Worker> list = workerDao.searchWorker(name);
		if(list.size()>0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(int i=0;i<list.size();i++){
				list.get(i).setTime(sdf.format(list.get(i).getJoinTime()));
			}
			return list;
		}
		return null;
	}
}
