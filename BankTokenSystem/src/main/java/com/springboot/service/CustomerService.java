package com.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.springboot.model.Customer;

public interface CustomerService {
	PriorityQueue<Customer> findAllCustomers();
	void saveCustomer(Customer customer);
	Map<Integer, Customer> findAllCounterStatus();
}
