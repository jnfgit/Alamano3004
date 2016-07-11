package com.beans;

import java.util.Date;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.jdt.internal.compiler.lookup.ConstraintExceptionFormula;
import org.hibernate.exception.ConstraintViolationException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
	private boolean termAndConditions;
	private String sexo;


	public String Confirmar(){
		
		try {
			EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
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
			u.setTelefono(Integer.parseInt(this.telefono.toString()));
			u.setFechaNacimiento(this.dateOfBirth);
			
			//if(password.equals(confirmPassword)){
				DataBaseHelper hel = new DataBaseHelper();
				String pass = hel.getSHA1FromPassword(this.password);
				u.setClavePass(pass);
			//}
			//else{
				//error("Las contraseñas no coinciden", "Detalle, el error ocurre al intentar validar las contraseña.");
				//return "error";
			//}
			
				
			
			if(termAndConditions == false){
				error("Debe aceptar términos y condiciones.", "Detalle, el error ocurre al no aceptar términos y condiciones." );
				return "error";
			}
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}catch(ConstraintViolationException ex){
			ex.printStackTrace();
			 //error("Ya existe este mail.", "Detalle, el error ocurre porque se repite el mail.");
			//return "error";
		} catch (Exception e) {
			e.printStackTrace();
			error("Se ha producido un error intentelo más tarde.", "Detalle, se ha producido un error, intentelo mas tarde.");
			return "error";
		}

		
		return "ok";
	}
	private void error(String parm1, String parm2){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, parm1, parm2));
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

	public boolean isTermAndConditions() {
		return termAndConditions;
	}
	public void setTermAndConditions(boolean termAndConditions) {
		this.termAndConditions = termAndConditions;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
