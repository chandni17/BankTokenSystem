package com.springboot.model;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Generated;

public class Customer implements Comparable<Customer>{
	private static final AtomicInteger count = new AtomicInteger(0);
    Integer id;
    String name;
    boolean isPremium;
    Integer priority;
    Integer counterNumber;
    Integer tokenNumber;
    public Customer(){ 	
    }
    public Customer(String name, boolean isPremium){
    	this.name= name;
    	this.isPremium = isPremium;
    	this.id = count.incrementAndGet();
    	this.priority = isPremium?1:2;
    }
	@Override
    public String toString() {
	    // TODO Auto-generated method stub
	    return this.name.toString();
    }
    @Override
    public int compareTo(Customer customer) {
     return  this.getPriority().compareTo(customer.getPriority());
    }
	public Integer getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(Integer tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
    public Integer getCounterNumber() {
		return counterNumber;
	}
	public void setCounterNumber(Integer counterNumber) {
		this.counterNumber = counterNumber;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsPremium() {
		return isPremium;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
}
