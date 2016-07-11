package com.beans;

import java.util.Date;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.persistence.Usuario;

import db.admin.DataBaseHelper;

public class PerfilBean {
	
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private String ci;
	private String sexo;
	private Date fechaNac;
	private String barrio;
	private String calle;
	private String apto;
	private String numero;
	
	private String password;
	private String password2;
	
	public String Confirmar(){
		
		/*EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Usuario u = new Usuario();
		
		u.setCreateDate(new Date(System.currentTimeMillis()));
		u.setUpdateDate(new Date(System.currentTimeMillis()));
		u.setUpdateProgram("Manual");
		u.setUpdateUser("jfernandez");
		
		u.setNombre(this.nombre);
		u.setApellido(this.apellido);
		u.setEmail(this.email);
		u.setTelefono(this.telefono);
		u.setFechaNacimiento(this.dateOfBirth);
		
		DataBaseHelper hel = new DataBaseHelper();
		String pass = hel.getSHA1FromPassword(this.password);
		u.setClavePass(pass);

		em.persist(u);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "";*/
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getApto() {
		return apto;
	}
	public void setApto(String apto) {
		this.apto = apto;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
