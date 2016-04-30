package com.beans;

import java.util.Date;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.persistence.Usuario;

import db.admin.DataBaseHelper;

public class UsuarioBean {
	
	private String nombre;
	private String apellido;
	private Long telefono;
	private String email;
	private Date dateOfBirth;
	private String password;
	private String confirmPassword;
	
	public String Confirmar(){
		
		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Usuario u = new Usuario();
		
		u.setCreate_date(new Date(System.currentTimeMillis()));
		u.setUpdate_date(new Date(System.currentTimeMillis()));
		u.setUpdate_program("Manual");
		u.setUpdate_user("jfernandez");
		
		u.setNombre(this.nombre);
		u.setApellido(this.apellido);
		u.setEmail(this.email);
		u.setTelefono(this.telefono);
		u.setFecha_nacimiento(this.dateOfBirth);
		
		DataBaseHelper hel = new DataBaseHelper();
		String pass = hel.getSHA1FromPassword(this.password);
		u.setClave_pass(pass);

		em.persist(u);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}	
}
