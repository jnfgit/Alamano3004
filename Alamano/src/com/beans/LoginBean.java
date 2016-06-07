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
	private boolean abrir = false;
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
			setPassword(null);
			abrir = true;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
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

	public boolean isAbrir() {
		if(abrir){
			boolean abrirAux = true;
			abrir = false;
			return abrirAux;
		}
		
		return abrir;
	}

	public void setAbrir(boolean abrir) {
		this.abrir = abrir;
	}
	
	public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
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

