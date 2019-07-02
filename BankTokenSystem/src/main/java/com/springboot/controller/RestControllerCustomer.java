package com.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Customer;
import com.springboot.service.CustomerService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders ="*")
@RequestMapping("/customerApi")
public class RestControllerCustomer {
	
	@Autowired
	CustomerService customerService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/customers/", method=RequestMethod.GET)
	public ResponseEntity<PriorityQueue<Customer>> getCustomers()
	{
		PriorityQueue<Customer> resultCustomer = customerService.findAllCustomers();
		if(resultCustomer.isEmpty())
		{
			return new ResponseEntity<PriorityQueue<Customer>>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<PriorityQueue<Customer>>(resultCustomer,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/counters/", method=RequestMethod.GET)
	public ResponseEntity<Map<Integer, Customer>> getCounterStatus()
	{
		Map<Integer, Customer> resultCouner = customerService.findAllCounterStatus();
		if(resultCouner.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin","*");
	    return ResponseEntity.ok()
	    	      .headers(responseHeaders).body(resultCouner);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/customersAdd/", method=RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		System.out.println("Adding Customer");
//		if(customerService.isEmployeeExsists(customer))
//		{
//			System.out.println("Unable to Create the User with the same name already exsists"+employee.getEmployeeName());
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		System.out.println("Adding Customer"+customer.getName()+customer.getIsPremium());
		customerService.saveCustomer(customer);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin","*");
	    return ResponseEntity.ok()
	    	      .headers(responseHeaders).body(customer);
	}
}
