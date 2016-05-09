package com.types;

import com.persistence.Usuario;

public interface ICustomerLookupService {

	public Usuario findCustomer(String userName, String password);
	
}
