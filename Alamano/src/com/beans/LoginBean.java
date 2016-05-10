package com.beans;


import java.io.Serializable;

import com.Implementations.CustomerLookupServiceImplementation;
import com.persistence.Usuario;

import db.admin.Admin;

public class LoginBean extends Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String emailAddress;
	private String password;
	private boolean rememberMe;

	public String login(){
		
		CustomerLookupServiceImplementation lookService = new CustomerLookupServiceImplementation();
		Usuario usuario = lookService.findCustomer(emailAddress, password);
		
		if(usuario != null){
			setUserName(usuario.getNombreCompleto());
			return "home";
		}else{
			return "error";
		}
	}
	
	public String logout2(){
		getSession().invalidate();
		return "";
	}
			
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
