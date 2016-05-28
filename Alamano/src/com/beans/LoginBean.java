package com.beans;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.Implementations.CustomerLookupServiceImplementation;
import com.persistence.Usuario;

import db.admin.Admin;

public class LoginBean extends Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String emailAddress;
	private String password;
	private boolean rememberMe;
	private int errorCode;
	private String errorDescription;

	public String login(){
		
		CustomerLookupServiceImplementation lookService = new CustomerLookupServiceImplementation();
		Usuario usuario = lookService.findCustomer(emailAddress, password);
		
		if(usuario != null){
			setUserName(usuario.getNombreCompleto());
			setEmailAddress(usuario.getEmail());
			return "home";
		}else{
			setUserName(null);
			setEmailAddress(null);
			setErrorCode(1);
			setErrorDescription("Usuario/Password incorrectos.");
			FacesContext.getCurrentInstance().addMessage("loginform:contrasenia", new FacesMessage("hola","hola2"));
			return null;
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
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}