package com.fwx.service;

import java.util.List;

import com.fwx.domain.Worker;



public interface IworkerService {
	public List<Worker> selAll();
	public List<Worker> selectAll();
	public boolean addWorker(Worker worker);
	public boolean delWorker(String[] id);
}
