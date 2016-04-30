package com.types;

import com.results.Customer;

public interface CustomerLookupService {

	public Customer findCustomer(String userName, String password);
	
}
