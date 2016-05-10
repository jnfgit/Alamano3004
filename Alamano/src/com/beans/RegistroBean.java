package com.beans;


import java.io.Serializable;
import java.util.Date;

import com.Implementations.CustomerLookupServiceImplementation;
import com.persistence.Usuario;

import db.admin.Admin;

public class RegistroBean extends Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private String telefono;
	private String sexo;
	
	private String emailAddress;
	private String password;
	private boolean termsAndConds;
		
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
	
	public String logout(){
		getSession().invalidate();
		return "";
	}
			
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public boolean isTermAndConds() {
		return termsAndConds;
	}
	public void setTermAndConds(boolean termsAndConds) {
		this.termsAndConds = termsAndConds;
	}
}
