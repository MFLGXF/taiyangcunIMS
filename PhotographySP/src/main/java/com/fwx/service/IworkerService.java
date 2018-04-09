package com.fwx.service;

import java.util.List;

import com.fwx.domain.Customer;
import com.fwx.domain.Worker;



public interface IworkerService {
	public List<Worker> selAll();
	public List<Worker> selectAll();
	public boolean addWorker(Worker worker);
	public boolean delWorker(String[] id);
	public boolean addCustomer(Customer customer);
	public List<Customer> selCustomer();
	public List<Customer> searchCustomer(String name);
	public List<Worker> searchWorker(String name);
	public List<Worker> selPhoto();
}
