package com.springboot.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.springboot.model.Customer;

@Configuration
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	static 	PriorityQueue<Customer> customerQueue = new PriorityQueue<>();
	static Map<Integer, Customer> counter;
	static int tokenNumber = 1;
	@Value("${counters.number}")
	private static int counterSize=5;
	static
	{
		counter = initializeCounters();
		Customer initiated1 = new Customer("Jack",false);
		initiated1.setTokenNumber(assignToken());
		//initiated1.setCounterNumber(assignCounter(initiated1));
		customerQueue.add(initiated1);
		initiated1.setCounterNumber(assignCounter(initiated1));
		Customer initiated2 = new Customer("Jill",true);
		initiated2.setTokenNumber(assignToken());
		//initiated2.setCounterNumber(assignCounter(initiated2));
		customerQueue.add(initiated2);
		initiated2.setCounterNumber(assignCounter(initiated2));
		
	}
	
	public static Map<Integer, Customer> initializeCounters() {
	    Map<Integer,Customer> counter= new LinkedHashMap<>();
		for(int i=0;i<counterSize;i++) {
			counter.put(i+1, null);
		}
		return counter;
	}

	
	public static int assignToken() {
		return tokenNumber++;	
	}


	public static int assignCounter(Customer customer) {
		Integer counterNumber = 0;
		// TODO Auto-generated method stub
		for(Map.Entry<Integer,Customer> entry:counter.entrySet())
		{
			if(entry.getValue() == null)
			{
				entry.setValue(customer);
				counterNumber = entry.getKey();
				customerQueue.remove(customer);
				break;
			}
		}
		return counterNumber;
	}
	
	@Override
	public PriorityQueue<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return customerQueue;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customerToAdd = new Customer(customer.getName(),customer.getIsPremium());
		customerToAdd.setTokenNumber(assignToken());
		//setCounterNumber(assignCounter(customerToAdd));
		customerQueue.add(customerToAdd);
		customerToAdd.setCounterNumber(assignCounter(customerToAdd));
		
	}


	@Override
	public Map<Integer,Customer> findAllCounterStatus() {
		// TODO Auto-generated method stub
		return counter;
	}
}
