package com.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
@NamedQueries({
	@NamedQuery (name = "validateUserByEmailAndPassword", query = "SELECT NOMBRE, APELLIDO, EMAIL FROM Usuario u WHERE (u.email = :email) AND u.clave_pass = SHA1(:clave)"),
	@NamedQuery (name = "getSHA1FromPass", query = "SELECT SHA1(:clave)")
})
*/

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private Date create_date;
	@Column(nullable=false)
	private Date update_date;
	@Column(nullable=false)
	private String update_user;
	@Column(nullable=false)
	private String update_program;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Usuario;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column
	private long telefono;
	@Column(nullable=false)
	private String email;
	@Column
	private Date fecha_nacimiento;
	@Column(nullable=false)
	private String clave_pass;
	
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public String getUpdate_program() {
		return update_program;
	}
	public void setUpdate_program(String update_program) {
		this.update_program = update_program;
	}
	public long getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(long id_Usuario) {
		this.id_Usuario = id_Usuario;
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
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getClave_pass() {
		return clave_pass;
	}
	public void setClave_pass(String clave_pass) {
		this.clave_pass = clave_pass;
	}
}
