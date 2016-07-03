package com.beans;


import java.io.IOException;
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
			setPassword(null);
			error();
			return "error";
		}
	}
	
	public String logout2(){
		this.emailAddress = null;
		invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/inicio.jsf");
		} catch (IOException e) {
			e.printStackTrace();			
		}
		return "";
	}
			
	public String getEmailAddress() {
 		if (emailAddress == null)
			return null;
 		if( emailAddress.compareTo("") == 0)
 			return null;
 		
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

	public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario/Contraseña incorrectos, intente nuevamente.", "Detalle, el error ocurre al intentar validar un usuario/contraseña."));
    }
}

